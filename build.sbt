import laika.config.{ChoiceConfig, MessageFilters, SelectionConfig, Selections, SyntaxHighlighting, TargetFormats}
import laika.format.Markdown
import laika.io.model.InputTree
import cats.effect.IO
import laika.ast.DocumentType
import laika.ast.Path.Root
import laika.ast./
import laika.helium.Helium
import laika.theme.config.Color

import scala.concurrent.duration.DurationDouble

ThisBuild / scalaVersion := "3.6.2"

lazy val root = project.in(file("."))

val laikaMdocBuild = taskKey[Set[File]]("Build mdoc, then laika")
val laikaMdocSite = taskKey[Unit]("Serve mdoc/laika site")
val theme = Helium.defaults
                  .all.themeColors(
      Color.hex("f99995"),
      Color.hex("fcbbb3"),
      Color.hex("9D2235"),
      Color.hex("cc1055"),
      Color.hex("f99995"),
      Color.hex("600f23"),
      (Color.hex("FA8072"), Color.hex("fcbbb3"))
    ).site.darkMode.disabled
                  .site.internalCSS(Root / "assets" / "extra.css").build

lazy val docs = project
  .in(file("website"))
  .dependsOn(root)
  .enablePlugins(MdocPlugin, LaikaPlugin)
  .settings(
    laikaExtensions := Seq(Markdown.GitHubFlavor, SyntaxHighlighting, ScalaCenterLinkDirectives, SyntaxExtension),
    laikaConfig := LaikaConfig.defaults
                              .withConfigValue(Selections(
                                SelectionConfig("language",
                                  ChoiceConfig("scala", "Scala 3"),
                                  ChoiceConfig("haskell", "Haskell")
                                ),
                                SelectionConfig("languageElixir",
                                  ChoiceConfig("scala", "Scala 3"),
                                  ChoiceConfig("elixir", "Elixir")
                                )
                              )),
    laikaInputs := InputTree[IO]
      .addDirectory(mdocOut.value.toString),
    laikaMdocBuild := Def.sequential((Compile / mdoc).toTask(" "), (Compile / laikaHTML)).value,
    laikaMdocSite := Def.sequential((Compile / mdoc).toTask(" "),
      Def.task[Unit] {
        (Compile / mdoc).toTask(" --watch ").value
        laikaPreview.value
      }
    ).value,
    laikaTheme := theme
  )
