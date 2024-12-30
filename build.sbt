import laika.config.{ChoiceConfig, MessageFilters, SelectionConfig, Selections, SyntaxHighlighting, TargetFormats}
import laika.format.Markdown
import laika.io.model.InputTree
import cats.effect.{IO => CIO}
import laika.ast.DocumentType
import laika.ast.Path.Root
import laika.ast./
import laika.helium.Helium
import laika.theme.config.Color

import scala.concurrent.duration.DurationDouble

ThisBuild / scalaVersion := "3.6.2"

lazy val root = project.in(file("."))

lazy val solutions = project.in(file("solutions"))
                            .enablePlugins(ScalaJSPlugin)
                            .settings(
                              libraryDependencies += "org.typelevel" %%% "cats-core" % "2.12.0",
                            )

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
                                ),
                                SelectionConfig("languageHaxe",
                                  ChoiceConfig("scala", "Scala 3"),
                                  ChoiceConfig("haxe", "Haxe")
                                ),
                                SelectionConfig("languageRuby",
                                  ChoiceConfig("scala", "Scala 3"),
                                  ChoiceConfig("ruby", "Ruby")
                                )
                              )).withRawContent,
    laikaInputs := InputTree[CIO]
      .addDirectory(mdocOut.value.toString),
    mdoc := {
      val solverJs = (solver / Compile / fullLinkJSOutput).value / "main.js"
      val dest = mdocOut.value / "src" / "js" / "solver.js"
      IO.createDirectory(mdocOut.value / "src" / "js")
      IO.copy(Seq(solverJs -> dest))
      mdoc.evaluated
    },
    laikaMdocBuild := Def.sequential((Compile / mdoc).toTask(" "), (Compile / laikaHTML)).value,
    laikaMdocSite := Def.sequential((Compile / mdoc).toTask(" "),
      Def.task[Unit] {
        (Compile / mdoc).toTask(" --watch ").value
        laikaPreview.value
      }
    ).value,
    laikaTheme := theme
  )

lazy val solver = project
  .in(file("solver"))
  .enablePlugins(ScalaJSPlugin)
  .settings(
    libraryDependencies ++= Seq(
      "org.scala-js" %%% "scalajs-dom" % "2.8.0",
      "com.raquo" %%% "laminar" % "17.1.0"
    ),
    scalaJSLinkerConfig ~= (_.withModuleKind(ModuleKind.ESModule))
  ).dependsOn(solutions)
