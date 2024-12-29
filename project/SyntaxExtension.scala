import laika.api.bundle.{ExtensionBundle, ParserBundle, Precedence}

object SyntaxExtension extends ExtensionBundle {
  val description: String = "Syntax highlighting"

  override def parsers: ParserBundle = new ParserBundle(
    syntaxHighlighters = Seq(
      ElixirSyntax,
      HaxeSyntax,
      RubySyntax
    )
  )
}
