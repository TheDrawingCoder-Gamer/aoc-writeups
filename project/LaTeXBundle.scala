import cats.data.NonEmptySet
import org.scilab.forge.jlatexmath.{DefaultTeXFont, TeXConstants, TeXFormula}
import laika.api.bundle.{BlockDirectives, DirectiveRegistry, ExtensionBundle, LinkDirectives, RenderOverrides, SpanDirectives, TemplateDirectives}
import laika.ast.*
import laika.ast.html.*
import cats.syntax.all.*
import laika.api.format.TagFormatter
import org.apache.batik.dom.GenericDOMImplementation
import org.apache.batik.svggen.{SVGGeneratorContext, SVGGraphics2D}
import org.scilab.forge.jlatexmath.cyrillic.CyrillicRegistration
import org.scilab.forge.jlatexmath.greek.GreekRegistration

import java.awt.{Color, Dimension, Insets}
import java.io.{ByteArrayInputStream, ByteArrayOutputStream, OutputStreamWriter}
import java.nio.charset.StandardCharsets
import javax.swing.JLabel
import laika.parse
import laika.parse.{BlockSource, LineSource}


case class LaTeXBlock(content: String, options: Options = Options.empty) extends Block {
  type Self = LaTeXBlock

  override def withOptions(options: Options): Self = copy(options = options)
}

object LaTeXBundle extends DirectiveRegistry {
  import scala.sys.process.*
  def renderLaTeX(input: String): String = {
    val is = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8))
    val os = new ByteArrayOutputStream()
    Process("npx katex -d -T --format html").#<(is).#>(os).!<

    os.flush()
    new String(os.toByteArray, StandardCharsets.UTF_8)
  }

  val custom: PartialFunction[(TagFormatter, Element), String] = {
    case (fmt, LaTeXBlock(content, _)) =>
      fmt.text(content)
  }

  object MyBlockDirectives {
    import BlockDirectives.dsl._
    import laika.parse.syntax.*
    import laika.parse.text.TextParsers.*
    import laika.parse.markup.BlockParsers.*

    val latexDirective = BlockDirectives.create("latex") {
      rawBody.map { it =>
        val rendered = renderLaTeX(it)

        RawContent(NonEmptySet.one("html"), s"<div>$rendered</div>")
      }
    }
  }

  override def spanDirectives: Seq[SpanDirectives.Directive] = Seq()

  override def blockDirectives: Seq[BlockDirectives.Directive] = Seq(MyBlockDirectives.latexDirective)

  override def templateDirectives: Seq[TemplateDirectives.Directive] = Seq()

  override def linkDirectives: Seq[LinkDirectives.Directive] = Seq()

}
