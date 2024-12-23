import laika.config.{MessageFilters, SyntaxHighlighting, TargetFormats}
import laika.format.Markdown
import laika.io.model.InputTree
import cats.effect.IO
import laika.ast.DocumentType
import laika.ast.Path.Root
import laika.ast./

import scala.concurrent.duration.DurationDouble

ThisBuild / scalaVersion := "3.6.2"

lazy val root = project.in(file("."))

val laikaMdocBuild = taskKey[Set[File]]("Build mdoc, then laika")
val laikaMdocSite = taskKey[Unit]("Serve mdoc/laika site")


lazy val docs = project
  .in(file("website"))
  .dependsOn(root)
  .enablePlugins(MdocPlugin, LaikaPlugin)
  .settings(
    laikaExtensions := Seq(Markdown.GitHubFlavor, SyntaxHighlighting, ScalaCenterLinkDirectives),
    laikaConfig := LaikaConfig.defaults
                              .withMessageFilters(MessageFilters.forVisualDebugging),
    laikaInputs := InputTree[IO]
      .addDirectory(mdocOut.value.toString),
    laikaMdocBuild := Def.sequential((Compile / mdoc).toTask(" "), (Compile / laikaHTML)).value,
    laikaMdocSite := Def.sequential((Compile / mdoc).toTask(" "),
      Def.task[Unit] {
        (Compile / mdoc).toTask(" --watch ").value
        laikaPreview.value
      }
    ).value
  )
