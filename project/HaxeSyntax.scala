import cats.data.{NonEmptyList, NonEmptySet}
import laika.api.bundle.SyntaxHighlighter
import laika.parse.builders.*
import laika.parse.code.CodeCategory.{BooleanLiteral, LiteralValue}
import laika.parse.code.common.Identifier.IdParser
import laika.parse.code.common.{CharLiteral, Comment, Identifier, Keywords, NumberLiteral, StringLiteral}
import laika.parse.code.{CodeCategory, CodeSpanParser}
import laika.parse.text.CharGroup.{digit, lowerAlpha, upperAlpha}
import laika.parse.code.syntax.*
import laika.parse.syntax.*
import laika.parse.text.TextParsers

object HaxeSyntax extends SyntaxHighlighter {

  override def language: NonEmptyList[String] = NonEmptyList.one("haxe")

  private val comment = Comment.singleLine("//") ++ Comment.multiLine("/*", "*/")
  private val keywords: CodeSpanParser =
    Keywords(
      "static",
      "public",
      "package",
      "class",
      "import",
      "using",
      "for",
      "in",
      "return",
      "final",
      "var",
      "if",
      "else"
    )
  private val charEscapes: CodeSpanParser =
    StringLiteral.Escape.unicode ++ StringLiteral.Escape.char
  private val numberLiteral =
    NumberLiteral.hex ++
      NumberLiteral.octal ++
      NumberLiteral.decimalFloat ++
      NumberLiteral.decimalInt
  private val stringLiteral =
    StringLiteral.singleLine('"').embed(charEscapes)
  private val identifier: IdParser = Identifier.alphaNum
                                               .withIdStartChars('$', '_')
                                               .withCategoryChooser(Identifier.upperCaseTypeName)
  private val declaration: CodeSpanParser = CodeSpanParser {
    val keyword = literal("function").asCode(CodeCategory.Keyword)
    val name = identifier.withCategory(CodeCategory.DeclarationName)
    (keyword ~ ws.asCode() ~ name).mapN { Seq(_, _, _) }
  }
  override def spanParsers: Seq[CodeSpanParser] = Seq(
    comment,
    CharLiteral.standard.embed(StringLiteral.Escape.char),
    stringLiteral,
    declaration,
    keywords,
    identifier,
    numberLiteral
  )
}
