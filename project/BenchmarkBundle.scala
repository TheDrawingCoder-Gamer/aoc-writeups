import laika.api.bundle.{BlockDirectives, DirectiveRegistry, LinkDirectives, SpanDirectives, TemplateDirectives}
import laika.ast.*
import laika.ast.html.*
import cats.syntax.all.*
import laika.api.config.ConfigDecoder
import laika.api.config.ConfigError.DecodingFailed
import laika.parse.SourceFragment


case class BenchmarkTiming(mean: Double, error: Double)



case class Benchmark(jvm: Option[BenchmarkTiming], js: Option[BenchmarkTiming], native: Option[BenchmarkTiming])



object BenchmarkBundle extends DirectiveRegistry {
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
      (attribute("unit").as[String].optional.map(_.getOrElse("ms")), attribute("p1").as[Benchmark].optional, attribute("p2").as[Benchmark].optional).mapN { (unit, p1, p2) =>
        if (p1.isEmpty && p2.isEmpty) {
          BlockSequence(Seq())
        } else {
          val sections = Seq(
            p1.map(benchmark =>
              BlockSequence(
                Seq(
                  Header(3, "Part 1"),
                  benchmarkAsTable(unit, benchmark)
                )
              )
            ),
            p2.map(benchmark =>
              BlockSequence(
                Seq(
                  Header(3, "Part 2"),
                  benchmarkAsTable(unit, benchmark)
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
