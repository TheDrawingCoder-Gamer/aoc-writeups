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
import java.io.{ByteArrayOutputStream, OutputStreamWriter}
import java.nio.charset.StandardCharsets
import javax.swing.JLabel
import laika.parse
import laika.parse.{BlockSource, LineSource}


case class LaTeXBlock(content: String, options: Options = Options.empty) extends Block {
  type Self = LaTeXBlock

  override def withOptions(options: Options): Self = copy(options = options)
}

object LaTeXBundle extends DirectiveRegistry {
  def renderLaTeX(input: String): String = {
    val domImpl = GenericDOMImplementation.getDOMImplementation
    val svgNS = "http://www.w3.org/2000/svg"
    val doc = domImpl.createDocument(svgNS, "svg", null)
    val ctx = SVGGeneratorContext.createDefault(doc)

    val g2 = new SVGGraphics2D(ctx, false)

    DefaultTeXFont.registerAlphabet(new CyrillicRegistration())
    DefaultTeXFont.registerAlphabet(new GreekRegistration())

    val formula = new TeXFormula(input)
    val icon = formula.createTeXIcon(TeXConstants.STYLE_DISPLAY, 20)
    icon.setInsets(new Insets(5, 5, 5, 5))
    g2.setSVGCanvasSize(new Dimension(icon.getIconWidth, icon.getIconHeight))

    val label = new JLabel()
    label.setForeground(new Color(0, 0, 0))
    icon.paintIcon(label, g2, 0, 0)

    val useCSS = true
    val os = new ByteArrayOutputStream()
    val out = new OutputStreamWriter(os, "UTF-8")

    g2.stream(out, useCSS)
    os.flush()

    val str = new String(os.toByteArray, StandardCharsets.UTF_8)
    os.close()
    str
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
