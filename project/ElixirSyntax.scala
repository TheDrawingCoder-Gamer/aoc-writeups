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

object ElixirSyntax extends SyntaxHighlighter {

  override def language: NonEmptyList[String] = NonEmptyList.of("elixir")

  private val comment: CodeSpanParser = Comment.singleLine("#")

  private val keywords = Keywords(BooleanLiteral)("true", "false") ++
    Keywords(LiteralValue)("nil") ++
    Keywords(
    "when",
    "and",
    "or",
    "not",
    "in",
    "fn",
    "do",
    "end",
    "catch",
    "rescue",
    "after",
    "else",
    "def",
    "defmodule",
      "for",
      "case"
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
                                               .withIdPartChars('?', '!', '_')
                                               .withCategoryChooser(Identifier.upperCaseTypeName)
  private val atom =
    identifier.withPrefix(TextParsers.literal(":")).withCategory(CodeCategory.LiteralValue)
  private val identifiers = Identifier
    .forCharacterSets(lowerAlpha.add('_') ++ upperAlpha, digit ++ NonEmptySet.of('?', '!'))
  private val declaration: CodeSpanParser = CodeSpanParser {
    val keyword = literal("def").asCode(CodeCategory.Keyword)
    val name = identifier.withCategory(CodeCategory.DeclarationName)
    (keyword ~ ws.asCode() ~ name).mapN { Seq(_, _, _) }
  }
  override def spanParsers: Seq[CodeSpanParser] =Seq(
    comment,
    CharLiteral.standard.embed(StringLiteral.Escape.char),
    stringLiteral,
    declaration,
    keywords,
    atom,
    identifier,
    numberLiteral
  )
}