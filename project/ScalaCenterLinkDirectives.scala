import laika.api.bundle.{BlockDirectives, DirectiveRegistry, LinkDirectives, SpanDirectives, TemplateDirectives}
import laika.ast.*
import laika.ast.html.*
import cats.syntax.all.*
import laika.parse.SourceFragment

object ScalaCenterLinkDirectives extends DirectiveRegistry {
  override val description: String = "Scala Center Links n stuff"


  def linkFromYD(cursor: DocumentCursor, source: SourceFragment, getLink: (Int, Int) => SpanLink): Either[(String, SourceFragment), Span] =
    (cursor.config.get[Int]("aoc.year"), cursor.config.get[Int]("aoc.day")).tupled.bimap(
      error => (s"Invalid year: $error", source),
      { case (year, day) =>  getLink(year, day) }
    )

  def paddedDay(day: Int): String =
    if (day < 10)
      s"0$day"
    else
      day.toString
  def aocLink(year: Int, day: Int): SpanLink =
    SpanLink(Seq(Text(s"Advent of Code $year, Day $day")), ExternalTarget(s"https://adventofcode.com/$year/day/$day"))
  def scalaCenterLink(year: Int, day: Int): SpanLink =
    SpanLink(Seq(Text(s"Scala Center Advent of Code $year, Day $day")), ExternalTarget(s"https://scalacenter.github.io/scala-advent-of-code${if (year != 2021) s"/$year" else ""}/puzzles/day${if (year != 2021) paddedDay(day) else day.toString}"))
  def gitSolnLink(year: Int, day: Int): SpanLink =
    SpanLink(Seq(Text(s"My Solution for $year, Day $day")), ExternalTarget(s"https://github.com/TheDrawingCoder-Gamer/adventofcode2024/blob/master/core/shared/src/main/scala/gay/menkissing/advent/y$year/Day${paddedDay(day)}.scala"))

  object MySpanDirectives {
    import SpanDirectives.dsl._
    val scalaLinkDirective = SpanDirectives.create("scalaLink") {
      (cursor, source).mapN { (cursor, source) =>
        linkFromYD(cursor, source, scalaCenterLink).fold(
          e => InvalidSpan(e._1, e._2),
          identity
        )
      }
    }
    val aocLinkDirective = SpanDirectives.create("aocLink") {
      (cursor, source).mapN { (cursor, source) =>
        linkFromYD(cursor, source, aocLink).fold(
          e => InvalidSpan(e._1, e._2),
          identity
        )
      }
    }
    val gitSolnDirective = SpanDirectives.create("gitSolnLink") {
      (cursor, source).mapN { (cursor, source) =>
        linkFromYD(cursor, source, gitSolnLink).fold(
          e => InvalidSpan(e._1, e._2),
          identity
        )
      }
    }
  }

  object MyBlockDirectives {
    import BlockDirectives.dsl._
    val ifValidYear = BlockDirectives.create("ifValidYear") {
      (cursor, source, parsedBody).mapN { (cursor, source, bodyContent) =>
        cursor.config.get[Int]("aoc.year").fold(
          error => InvalidBlock(s"Invalid year: $error", source),
          year => BlockSequence(if (year >= 2021) bodyContent else Seq())
        )
      }
    }.allowCursorInBuildPhase
    val scalaLinkDirective = BlockDirectives.create("scalaLink") {
      (cursor, source).mapN { (cursor, source) =>
        linkFromYD(cursor, source, scalaCenterLink).fold(
          e => InvalidBlock(e._1, e._2),
          r => Paragraph(r)
        )
      }
    }
    val aocLinkDirective = BlockDirectives.create("aocLink") {
      (cursor, source).mapN { (cursor, source) =>
        linkFromYD(cursor, source, aocLink).fold(
          e => InvalidBlock(e._1, e._2),
          r => Paragraph(r)
        )
      }
    }
    val gitSolnDirective = BlockDirectives.create("gitSolnLink") {
      (cursor, source).mapN { (cursor, source) =>
        linkFromYD(cursor, source, gitSolnLink).fold(
          e => InvalidBlock(e._1, e._2),
          r => Paragraph(r)
        )
      }
    }

    def bustedHeader(level: Int, text: String): Block =
      BlockSequence(HTMLStartTag(s"h$level", List()), Text(text), HTMLEndTag(s"h$level"))


    def browserPart(day: Int, year: Int, part2: Boolean): Block = {
    BlockSequence(
      HTMLStartTag("div", List(HTMLAttribute("id", List(Text(s"day$day${if (part2) "p2" else "p1"}")), Some('"')))),
      HTMLEndTag("div"),
      HTMLScriptElement(
        List(HTMLAttribute("type", List(Text("module")), Some('"'))),
        s"""
           |import solver from "../src/js/solver.js"
           |
           |solver($day, "$year", $part2)
           |""".stripMargin
        )
      )


    }


    val solutionDirective = BlockDirectives.create("solution") {
      (cursor, source, attribute("hasPart1").as[Boolean].optional, attribute("hasPart2").as[Boolean].optional).mapN {
        (cursor, source, hasPart1, hasPart2) =>
        (cursor.config.get[Int]("aoc.day"), cursor.config.get[Int]("aoc.year")).tupled.fold(
          e => InvalidBlock(e.message, source),
          { case (day, year) =>
              BlockSequence(
                content = Seq(Header(2, "Run it in the browser!")) ++ Seq[Option[Block]](

                  if (hasPart1.getOrElse(true)) Some(browserPart(day, year, part2 = false)) else None,
                  if (hasPart2.getOrElse(true)) Some(browserPart(day, year, part2 = true)) else None
                ).flatten
              )
          }
        )
      }
    }.allowCursorInBuildPhase

  }

  override def spanDirectives: Seq[SpanDirectives.Directive] = Seq(MySpanDirectives.scalaLinkDirective, MySpanDirectives.aocLinkDirective, MySpanDirectives.gitSolnDirective)

  override def blockDirectives: Seq[BlockDirectives.Directive] = Seq(
    MyBlockDirectives.ifValidYear,
    MyBlockDirectives.scalaLinkDirective,
    MyBlockDirectives.aocLinkDirective,
    MyBlockDirectives.solutionDirective,
    MyBlockDirectives.gitSolnDirective)

  override def templateDirectives: Seq[TemplateDirectives.Directive] = Seq()

  override def linkDirectives: Seq[LinkDirectives.Directive] = Seq()
}
