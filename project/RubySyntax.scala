import cats.data.NonEmptyList
import laika.api.bundle.SyntaxHighlighter
import laika.parse.builders.*
import laika.parse.code.common.Identifier.IdParser
import laika.parse.code.common.*
import laika.parse.code.syntax.*
import laika.parse.code.{CodeCategory, CodeSpanParser}
import laika.parse.syntax.*

object RubySyntax extends SyntaxHighlighter {

  override def language: NonEmptyList[String] = NonEmptyList.one("ruby")

  private val comment = Comment.singleLine("//") ++ Comment.multiLine("/*", "*/")
  private val keywords: CodeSpanParser =
    Keywords(
      "def",
      "for",
      "in",
      "do",
      "end",
      "return"
    )
  private val charEscapes: CodeSpanParser =
    StringLiteral.Escape.unicode ++ StringLiteral.Escape.char
  private val numberLiteral =
    NumberLiteral.hex ++
      NumberLiteral.octal ++
      NumberLiteral.decimalFloat ++
      NumberLiteral.decimalInt
  private val regexLiteral =
    StringLiteral.singleLine('/')
  private val stringLiteral =
    StringLiteral.singleLine('"').embed(charEscapes)
  private val identifier: IdParser = Identifier.alphaNum
                                               .withIdStartChars('$', '_')
                                               .withIdPartChars('!', '?')
                                               .withCategoryChooser(Identifier.upperCaseTypeName)
  private val declaration: CodeSpanParser = CodeSpanParser {
    val keyword = literal("def").asCode(CodeCategory.Keyword)
    val name = identifier.withCategory(CodeCategory.DeclarationName)
    (keyword ~ ws.asCode() ~ name).mapN { Seq(_, _, _) }
  }
  override def spanParsers: Seq[CodeSpanParser] = Seq(
    comment,
    CharLiteral.standard.embed(StringLiteral.Escape.char),
    regexLiteral,
    stringLiteral,
    declaration,
    keywords,
    identifier,
    numberLiteral
  )
}
