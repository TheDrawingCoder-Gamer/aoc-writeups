import laika.api.bundle.{BlockDirectives, DirectiveRegistry, LinkDirectives, SpanDirectives, TemplateDirectives}
import laika.ast.*
import laika.ast.html.*
import cats.syntax.all.*
import laika.api.config.{ConfigDecoder, ConfigEncoder, ConfigError, ConfigValue, DefaultKey, Field, Traced}
import laika.api.config.ConfigError.DecodingFailed
import laika.parse.SourceFragment

import java.util.concurrent.TimeUnit
import scala.collection.immutable.ListMap
import scala.concurrent.duration.TimeUnit


case class BenchmarkTiming(mean: Double, error: Double, unit: Option[TimeUnit] = None, convertTo: Option[TimeUnit] = None) {
  def convertTiming(defaultUnit: TimeUnit, defaultDest: TimeUnit): BenchmarkTiming = {
    val source = unit.getOrElse(defaultUnit)
    val dest = convertTo.getOrElse(defaultDest)
    BenchmarkTiming(BenchmarkBundle.convertTimeUnit(mean, source, dest), BenchmarkBundle.convertTimeUnit(error, source, dest), Some(dest))
  }
}


case class Benchmark(values: Map[String, BenchmarkTiming], unit: Option[TimeUnit] = None, convertTo: Option[TimeUnit] = None) {
  def convertTiming(defaultUnit: TimeUnit, defaultDest: TimeUnit): Benchmark = {
    val source = unit.getOrElse(defaultUnit)
    val dest = convertTo.getOrElse(defaultDest)
    Benchmark(
      values.mapValues(_.convertTiming(source, dest)),
        Some(dest)
    )
  }
}

case class BenchmarkNames(value: ListMap[String, String]) extends AnyVal

object BenchmarkNames {
  def apply(values: (String, String)*): BenchmarkNames =
    BenchmarkNames(ListMap(values*))
}

object BenchmarkBundle extends DirectiveRegistry {
  def convertTimeUnit(amount: Double, from: TimeUnit, to: TimeUnit): Double = {
    // is from or to the larger unit?
    if (from.ordinal < to.ordinal) { // from is smaller
      amount / from.convert(1, to)
    }
    else amount * to.convert(1, from)
  }

  def convertMapTiming(map: Map[String, BenchmarkTiming], from: TimeUnit, to: TimeUnit): Map[String, BenchmarkTiming] =
    map.mapValues(y => y.convertTiming(from, to))

  object implicits {
    import laika.api.config.ConfigValue.*
    implicit val benchmarkNameDecoder: ConfigDecoder[BenchmarkNames] =
      listMapDecoder[String].map(BenchmarkNames.apply)

    implicit val benchmarkNameEncoder: ConfigEncoder[BenchmarkNames] =
      ConfigEncoder.map[String].contramap(_.value)

    implicit val benchmarkNamesDefaultKey: DefaultKey[BenchmarkNames] = DefaultKey("benchmark_names")

    implicit val timeUnitDecoder: ConfigDecoder[TimeUnit] =
      ConfigDecoder.string.flatMap {
        case "ms" => Right(TimeUnit.MILLISECONDS)
        case "s" => Right(TimeUnit.SECONDS)
        case "us" => Right(TimeUnit.MICROSECONDS)
        case "ns" => Right(TimeUnit.NANOSECONDS)
        case x => Left(DecodingFailed(s"$x is not a valid time unit."))
      }

    implicit def listMapDecoder[B](implicit valueDecoder: ConfigDecoder[B]): ConfigDecoder[ListMap[String, B]] = {
      case Traced(ov: ObjectValue, origin) =>
        val (errors, results) = ov.values.toList.map { field =>
          valueDecoder(Traced(field.value, origin)).map((field.key, _))
        }.separate
        if (errors.nonEmpty)
          Left(DecodingFailed(s"One or more errors decoding map values: ${errors.mkString(", ")}"))
        else Right(ListMap(results*))
      case Traced(invalid, _) => Left(ConfigError.InvalidType("Object", invalid))
    }

    implicit def listMapEncoder[B](implicit valueEncoder: ConfigEncoder[B]): ConfigEncoder[ListMap[String, B]] = { t =>
      ObjectValue {
        t.map { case (x, y) =>
          Field(x, valueEncoder(y))
        }.toSeq
      }
    }

    implicit val benchmarkTimingDecoder: ConfigDecoder[BenchmarkTiming] = new ConfigDecoder[BenchmarkTiming] {

      def apply(value: Traced[ConfigValue]) = value.value match {
        case ArrayValue (values) =>
          values.length match {
            case 2 =>
              ConfigDecoder.seq[Double].apply(value).map(it => BenchmarkTiming(it.head, it.tail.head))
            case 3 =>
              val (errors, results) = values.take(2).toList.map(it => ConfigDecoder.double(Traced(it, value.origin))).separate
              if (errors.nonEmpty)
                Left(DecodingFailed(s"One or more errors decoding mean and stderror of benchmark timing: ${errors.mkString(", ")}"))
              else timeUnitDecoder(Traced(values.last, value.origin)).map(it => BenchmarkTiming(results.head, results.tail.head, Some(it)))
            case 4 =>
              val (errors, results) = values.take(2).toList.map(it => ConfigDecoder.double(Traced(it, value.origin))).separate
              if (errors.nonEmpty)
                Left(DecodingFailed(s"One or more errors decoding mean and stderror of benchmark timing: ${errors.mkString(", ")}"))
              else timeUnitDecoder(Traced(values(2), value.origin)).flatMap { unit =>
                timeUnitDecoder(Traced(values(3), value.origin)).map { asUnit =>
                  BenchmarkTiming(results.head, results.tail.head, Some(unit), Some(asUnit))
                }
              }
          }
        case ov @ ObjectValue(_) =>
          val conf = ov.toConfig
          for {
            mean <- conf.get[Double]("mean")
            stderr <- conf.get[Double]("stderr")
            unit <- conf.getOpt[TimeUnit]("unit")
            asUnit <- conf.getOpt[TimeUnit]("asUnit")
          } yield BenchmarkTiming(mean, stderr, unit, asUnit)
        case invalid =>
          Left(ConfigError.InvalidType("Object or Array", invalid))

      }
    }
    implicit val benchmarkDecoder: ConfigDecoder[Benchmark] = {
      case Traced(ObjectValue(values), origin) =>
        type ConfigErrorEither[B] = Either[ConfigError, B]
        val unit = values.find(_.key == "unit")
        val asUnit = values.find(_.key == "asUnit")
        val vs = values.filter { it =>
          it.key match {
            case "unit" | "asUnit" => false
            case _ => true
          }
        }
        unit.traverse[ConfigErrorEither, TimeUnit](it => timeUnitDecoder(Traced(it.value, origin))).flatMap { unit =>
          asUnit.traverse[ConfigErrorEither, TimeUnit](it => timeUnitDecoder(Traced(it.value, origin))).flatMap { asUnit =>
            listMapDecoder[BenchmarkTiming].apply(Traced(ObjectValue(vs), origin)).map { timings =>
              Benchmark(timings, unit, asUnit)
            }
          }
        }
      case Traced(invalid, _) => Left(ConfigError.InvalidType("Object", invalid))
    }
  }

  import implicits.*




  def rowForTiming(name: String, unit: TimeUnit)(timing: BenchmarkTiming): Row = {
    val daUnit = unitName(timing.unit.getOrElse(unit))
    Row(
      Cell(CellType.HeadCell, Seq(BlockSequence(name))),
      Cell(CellType.BodyCell, Seq(BlockSequence(s"%1.3f $daUnit".format(timing.mean)))),
      Cell(CellType.BodyCell, Seq(BlockSequence(s"+/- %1.3f $daUnit".format(timing.error))))
    )

  }

  def unitName(unit: TimeUnit): String = {
    unit match {
      case TimeUnit.NANOSECONDS => "ns"
      case TimeUnit.MICROSECONDS => "μs"
      case TimeUnit.MILLISECONDS => "ms"
      case TimeUnit.SECONDS => "s"
      case TimeUnit.MINUTES => "m"
      case TimeUnit.HOURS => "h"
      case TimeUnit.DAYS => "days"
    }
  }

  def benchmarkAsTable(config: ListMap[String, String], unit: TimeUnit, benchmark: Benchmark): Block = {
    val daUnit = benchmark.unit.getOrElse(unit)
    val rows = config.keysIterator.flatMap { it =>
      benchmark.values.get(it).map { y =>
        rowForTiming(config(it), daUnit)(y)
      }
    }.toSeq

    if (rows.isEmpty) {
      BlockSequence(Seq())
    } else {
      Table(
        rows.head,
        rows.tail: _*
      ).copy(head = TableHead(Seq(
        Row(
          Cell(CellType.HeadCell, Seq(BlockSequence(""))),
          Cell(CellType.HeadCell, Seq(BlockSequence("Mean"))),
          Cell(CellType.HeadCell, Seq(BlockSequence("Error")))
        )
      )))
    }


  }

  object MyBlockDirectives {
    import BlockDirectives.dsl.*

    val benchmarkSection = BlockDirectives.create("benchmarkSection") {
      (cursor, attribute("unit").as[TimeUnit].optional.map(_.getOrElse(TimeUnit.MILLISECONDS)),
        attribute("asUnit").as[TimeUnit].optional,
        attribute("p1").as[Benchmark].optional,
        attribute("p2").as[Benchmark].optional, source).mapN { (cursor, unit, asUnit, p1, p2, source) =>
        cursor.config.get[BenchmarkNames].fold(
          err => InvalidBlock(err.message, source),
          names => {
            val p1unitGood = p1.flatMap(_.convertTo).orElse(asUnit).getOrElse(unit)
            val p2unitGood = p2.flatMap(_.convertTo).orElse(asUnit).getOrElse(unit)
            if (p1.isEmpty && p2.isEmpty) {
              BlockSequence(Seq())
            } else {
              val sections = Seq(
                p1.map(benchmark =>
                  BlockSequence(
                    Seq(
                      Header(3, "Part 1"),
                      benchmarkAsTable(names.value, p1unitGood, benchmark.convertTiming(unit, p1unitGood))
                    )
                  )
                ),
                p2.map(benchmark =>
                  BlockSequence(
                    Seq(
                      Header(3, "Part 2"),
                      benchmarkAsTable(names.value, p2unitGood, benchmark.convertTiming(unit, p2unitGood))
                    )
                  )
                )
              ).flatten
              BlockSequence(
                Seq(
                  Header(2, "Benchmark")
                ) ++ sections
              )
            }
          }
        )
      }
    }.allowCursorInBuildPhase
  }

  override def spanDirectives: Seq[SpanDirectives.Directive] = Seq()

  override def blockDirectives: Seq[BlockDirectives.Directive] = Seq(MyBlockDirectives.benchmarkSection)

  override def templateDirectives: Seq[TemplateDirectives.Directive] = Seq()

  override def linkDirectives: Seq[LinkDirectives.Directive] = Seq()
}
