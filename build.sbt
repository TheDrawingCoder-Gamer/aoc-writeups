import laika.config.{ChoiceConfig, MessageFilters, SelectionConfig, Selections, SyntaxHighlighting, TargetFormats}
import laika.format.Markdown
import laika.io.model.InputTree
import cats.effect.{IO => CIO}
import laika.ast.DocumentType
import laika.ast.Path.Root
import laika.helium.Helium
import laika.theme.config.{Color, StyleAttributes, CrossOrigin}

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
      .site.internalCSS(Root / "assets" / "extra.css")
      .site.externalCSS("https://cdn.jsdelivr.net/npm/katex@0.16.19/dist/katex.min.css",
    StyleAttributes.defaults.withIntegrity("sha384-7lU0muIg/i1plk7MgygDUp3/bNRA65orrBub4/OSWHECgwEsY83HaS1x3bljA/XV").withCrossOrigin(CrossOrigin.Anonymous))
      .site.inlineJS(
    """
      |window.onload = function() {
      |  const ls = document.getElementById("sidebar").getElementsByClassName("active");
      |  if (ls.length > 0) {
      |    ls[0].scrollIntoView({"block":"center"});
      |  }
      |}
      |""".stripMargin)
                  .build

lazy val docs = project
  .in(file("website"))
  .dependsOn(root)
  .enablePlugins(MdocPlugin, LaikaPlugin)
  .settings(
    laikaExtensions := Seq(Markdown.GitHubFlavor, SyntaxHighlighting, ScalaCenterLinkDirectives, SyntaxExtension, LaTeXBundle, BenchmarkBundle),
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
                              )).withRawContent
                              // required bc of jank
                              .withMessageFilters(MessageFilters.forVisualDebugging),
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
      "com.raquo" %%% "laminar" % "17.1.0",
      "gay.menkissing" %%% "adventofcode2024" % "0.1.0-SNAPSHOT"
    ),
    scalaJSLinkerConfig ~= (_.withModuleKind(ModuleKind.ESModule))
  )
