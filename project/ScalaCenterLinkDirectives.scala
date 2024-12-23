import laika.api.bundle.{BlockDirectives, DirectiveRegistry, LinkDirectives, SpanDirectives, TemplateDirectives}
import laika.ast.*

import cats.syntax.all.*

object ScalaCenterLinkDirectives extends DirectiveRegistry {
  override val description: String = "Scala Center Links n stuff"

  def scalaCenterLink(year: Int, day: Int): SpanLink =
    SpanLink(Seq(Text(s"Scala Center Advent of Code $year, Day $day")), ExternalTarget(s"https://scalacenter.github.io/scala-advent-of-code${if (year != 2021) s"/$year" else ""}/puzzles/day$day"))
  object MySpanDirectives {
    import SpanDirectives.dsl._
    val scalaLinkDirective = SpanDirectives.create("scalaLink") {
      (cursor, source).mapN { (cursor, source) =>
        (cursor.config.get[Int]("aoc.year"), cursor.config.get[Int]("aoc.day")).tupled.fold(
          error => InvalidSpan(s"Invalid year: $error", source),
          { case (year, day) =>  scalaCenterLink(year, day) }
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
        (cursor.config.get[Int]("aoc.year"), cursor.config.get[Int]("aoc.day")).tupled.fold(
          error => InvalidBlock(s"Invalid year: $error", source),
          { case (year, day) =>  Paragraph(scalaCenterLink(year, day)) }
        )
      }
    }
  }

  override def spanDirectives: Seq[SpanDirectives.Directive] = Seq(MySpanDirectives.scalaLinkDirective)

  override def blockDirectives: Seq[BlockDirectives.Directive] = Seq(MyBlockDirectives.ifValidYear, MyBlockDirectives.scalaLinkDirective)

  override def templateDirectives: Seq[TemplateDirectives.Directive] = Seq()

  override def linkDirectives: Seq[LinkDirectives.Directive] = Seq()
}
