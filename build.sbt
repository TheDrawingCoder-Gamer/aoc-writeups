import laika.config.{MessageFilters, SyntaxHighlighting, TargetFormats}
import laika.format.Markdown
import laika.io.model.InputTree
import cats.effect.IO
import laika.ast.DocumentType
import laika.ast.Path.Root
import laika.ast./

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
    Laika / sourceDirectories := Seq(mdocOut.value),
    laikaMdocBuild := Def.task[Set[File]] {
      (Compile / mdoc).toTask(" ").value
      (Compile / laikaHTML).value
    }.value,
    laikaMdocSite := Def.task[Unit] {
      (Compile / mdoc).toTask(" --watch ").value
      laikaPreview.value
    }.value
  )
