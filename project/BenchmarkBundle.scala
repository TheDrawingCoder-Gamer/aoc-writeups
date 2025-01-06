import laika.api.bundle.{BlockDirectives, DirectiveRegistry, LinkDirectives, SpanDirectives, TemplateDirectives}
import laika.ast.*
import laika.ast.html.*
import cats.syntax.all.*
import laika.api.config.ConfigDecoder
import laika.api.config.ConfigError.DecodingFailed
import laika.parse.SourceFragment

import java.util.concurrent.TimeUnit
import scala.concurrent.duration.TimeUnit


case class BenchmarkTiming(mean: Double, error: Double) {
  def convertTiming(source: TimeUnit, dest: TimeUnit): BenchmarkTiming =
    BenchmarkTiming(BenchmarkBundle.convertTimeUnit(mean, source, dest), BenchmarkBundle.convertTimeUnit(error, source, dest))
}


case class Benchmark(jvm: Option[BenchmarkTiming], js: Option[BenchmarkTiming], native: Option[BenchmarkTiming]) {
  def convertTiming(source: TimeUnit, dest: TimeUnit): Benchmark =
    Benchmark(
      jvm.map(_.convertTiming(source, dest)),
      js.map(_.convertTiming(source, dest)),
      native.map(_.convertTiming(source, dest))
    )
}

object BenchmarkBundle extends DirectiveRegistry {
  def convertTimeUnit(amount: Double, from: TimeUnit, to: TimeUnit): Double = {
    // is from or to the larger unit?
    if (from.ordinal < to.ordinal) { // from is smaller
      amount / from.convert(1, to)
    }
    else amount * to.convert(1, from)
  }

  implicit val timeUnitDecoder: ConfigDecoder[TimeUnit] =
    ConfigDecoder.string.flatMap {
      case "ms" => Right(TimeUnit.MILLISECONDS)
      case "s" => Right(TimeUnit.SECONDS)
      case "us" => Right(TimeUnit.MICROSECONDS)
      case "ns" => Right(TimeUnit.NANOSECONDS)
      case x => Left(DecodingFailed(s"$x is not a valid time unit."))
    }

  implicit val benchmarkTimingDecoder: ConfigDecoder[BenchmarkTiming] =
    ConfigDecoder.seq[Double].flatMap { seq =>
      if (seq.length == 2) {
        Right(BenchmarkTiming(seq.head, seq.tail.head))
      } else {
        Left(DecodingFailed("Benchmarking timing must be of length 2 (the mean and the error)"))
      }
    }
  implicit val benchmarkDecoder: ConfigDecoder[Benchmark] =
    ConfigDecoder.map[BenchmarkTiming](benchmarkTimingDecoder).map(map => Benchmark(map.get("jvm"), map.get("js"), map.get("native")))


  def rowForTiming(name: String, unit: String)(timing: BenchmarkTiming): Row = {
    Row(
      Cell(CellType.HeadCell, Seq(BlockSequence(name))),
      Cell(CellType.BodyCell, Seq(BlockSequence(s"%1.3f $unit".format(timing.mean)))),
      Cell(CellType.BodyCell, Seq(BlockSequence(s"+/- %1.3f $unit".format(timing.error))))
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

  def benchmarkAsTable(unit: String, benchmark: Benchmark): Block = {
    val rows = Seq(
      benchmark.jvm.map(rowForTiming("JVM", unit)),
      benchmark.js.map(rowForTiming("JS", unit)),
      benchmark.native.map(rowForTiming("Native", unit))
    ).flatten
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

    val benchmarkDirective = BlockDirectives.create("benchmark") {
      (attribute("unit").as[String].optional, attribute("benchmark").as[Benchmark], source).mapN[Block] { (unit, benchmark, source) =>
        benchmarkAsTable(unit.getOrElse("ms"), benchmark)
      }
    }

    val benchmarkSection = BlockDirectives.create("benchmarkSection") {
      (attribute("unit").as[TimeUnit].optional.map(_.getOrElse(TimeUnit.MILLISECONDS)),
        attribute("p1").as[Benchmark].optional,
        attribute("p2").as[Benchmark].optional,
        attribute("p1unit").as[TimeUnit].optional,
        attribute("p2unit").as[TimeUnit].optional).mapN { (unit, p1, p2, p1unit, p2unit) =>
        val p1unitGood = p1unit.getOrElse(unit)
        val p2unitGood = p2unit.getOrElse(unit)
        if (p1.isEmpty && p2.isEmpty) {
          BlockSequence(Seq())
        } else {
          val sections = Seq(
            p1.map(benchmark =>
              BlockSequence(
                Seq(
                  Header(3, "Part 1"),
                  benchmarkAsTable(unitName(p1unitGood), benchmark.convertTiming(unit, p1unitGood))
                )
              )
            ),
            p2.map(benchmark =>
              BlockSequence(
                Seq(
                  Header(3, "Part 2"),
                  benchmarkAsTable(unitName(p2unitGood), benchmark.convertTiming(unit, p2unitGood))
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
    }
  }

  override def spanDirectives: Seq[SpanDirectives.Directive] = Seq()

  override def blockDirectives: Seq[BlockDirectives.Directive] = Seq(MyBlockDirectives.benchmarkDirective, MyBlockDirectives.benchmarkSection)

  override def templateDirectives: Seq[TemplateDirectives.Directive] = Seq()

  override def linkDirectives: Seq[LinkDirectives.Directive] = Seq()
}
