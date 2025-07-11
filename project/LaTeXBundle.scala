import cats.data.NonEmptySet
import laika.api.bundle.{BlockDirectives, DirectiveRegistry, ExtensionBundle, LinkDirectives, RenderOverrides, SpanDirectives, TemplateDirectives}
import laika.ast.*
import laika.ast.html.*
import cats.syntax.all.*
import laika.api.format.TagFormatter
import uk.ac.ed.ph.snuggletex.{DOMOutputOptions, DOMPostProcessor, SerializationMethod, SnuggleEngine, SnuggleInput, XMLStringOutputOptions}

import java.awt.{Color, Dimension, Insets}
import java.io.{ByteArrayInputStream, ByteArrayOutputStream, OutputStreamWriter}
import java.nio.charset.StandardCharsets
import javax.swing.JLabel
import laika.parse
import laika.parse.{BlockSource, LineSource}
import org.w3c.dom
import uk.ac.ed.ph.snuggletex.utilities.StylesheetManager

import javax.xml.parsers.DocumentBuilderFactory


case class LaTeXBlock(content: String, options: Options = Options.empty) extends Block {
  type Self = LaTeXBlock

  override def withOptions(options: Options): Self = copy(options = options)
}

object LaTeXBundle extends DirectiveRegistry {
  import scala.sys.process.*
  val engine = new SnuggleEngine()

  object InlineProcessor extends DOMPostProcessor {
    override def postProcessDOM(workDocument: dom.Document, options: DOMOutputOptions, stylesheetManager: StylesheetManager): dom.Document = {
      val doc = workDocument.cloneNode(true).asInstanceOf[dom.Document]
      doc.getDocumentElement.removeAttribute("display")
      doc
    }
  }

  def renderLaTeX(input: String, displayMode: Boolean = true): String = {
    val session = engine.createSession()
    val wrapper = if (displayMode) "$$" else "$"
    val goodInput = new SnuggleInput(wrapper + input + wrapper)
    session.parseInput(goodInput)

    val options = new XMLStringOutputOptions()
    options.setSerializationMethod(SerializationMethod.XML)
    options.setIndenting(false)
    options.setEncoding("UTF-8")
    options.setAddingMathSourceAnnotations(true)


    session.buildXMLString(options)
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

  object MySpanDirectives {
    import SpanDirectives.dsl._

    val latexDirective = SpanDirectives.create("latex") {
      rawBody.map { it =>
        val rendered = renderLaTeX(it, displayMode = false)

        RawContent(NonEmptySet.one("html"), s"<span>$rendered</span>")
      }
    }
  }

  override def spanDirectives: Seq[SpanDirectives.Directive] = Seq(MySpanDirectives.latexDirective)

  override def blockDirectives: Seq[BlockDirectives.Directive] = Seq(MyBlockDirectives.latexDirective)

  override def templateDirectives: Seq[TemplateDirectives.Directive] = Seq()

  override def linkDirectives: Seq[LinkDirectives.Directive] = Seq()

}
