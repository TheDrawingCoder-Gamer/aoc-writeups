import laika.api.bundle.{BlockDirectives, DirectiveRegistry, LinkDirectives, SpanDirectives, TemplateDirectives}
import laika.ast.*
import cats.syntax.all.*
import laika.parse.SourceFragment

object ScalaCenterLinkDirectives extends DirectiveRegistry {
  override val description: String = "Scala Center Links n stuff"


  def linkFromYD(cursor: DocumentCursor, source: SourceFragment, getLink: (Int, Int) => SpanLink): Either[(String, SourceFragment), Span] =
    (cursor.config.get[Int]("aoc.year"), cursor.config.get[Int]("aoc.day")).tupled.bimap(
      error => (s"Invalid year: $error", source),
      { case (year, day) =>  getLink(year, day) }
    )
  def aocLink(year: Int, day: Int): SpanLink =
    SpanLink(Seq(Text(s"Advent of Code $year, Day $day")), ExternalTarget(s"https://adventofcode.com/$year/day/$day"))
  def scalaCenterLink(year: Int, day: Int): SpanLink =
    SpanLink(Seq(Text(s"Scala Center Advent of Code $year, Day $day")), ExternalTarget(s"https://scalacenter.github.io/scala-advent-of-code${if (year != 2021) s"/$year" else ""}/puzzles/day$day"))
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
    }
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
  }

  override def spanDirectives: Seq[SpanDirectives.Directive] = Seq(MySpanDirectives.scalaLinkDirective, MySpanDirectives.aocLinkDirective)

  override def blockDirectives: Seq[BlockDirectives.Directive] = Seq(
    MyBlockDirectives.ifValidYear,
    MyBlockDirectives.scalaLinkDirective,
    MyBlockDirectives.aocLinkDirective)

  override def templateDirectives: Seq[TemplateDirectives.Directive] = Seq()

  override def linkDirectives: Seq[LinkDirectives.Directive] = Seq()
}
