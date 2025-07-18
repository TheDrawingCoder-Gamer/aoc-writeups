addSbtPlugin("org.scalameta" % "sbt-mdoc" % "2.6.2")
addSbtPlugin("org.scala-js" % "sbt-scalajs" % "1.17.0")
addSbtPlugin("org.typelevel" % "laika-sbt" % "1.3.1")

// make
addSbtPlugin("pl.project13.scala" % "sbt-jmh" % "0.4.7")
addSbtPlugin("org.scala-native" % "sbt-scala-native" % "0.5.4")
addSbtPlugin("org.portable-scala" % "sbt-scala-native-crossproject" % "1.3.2")
addSbtPlugin("org.scala-js" % "sbt-scalajs" % "1.17.0")
addSbtPlugin("org.portable-scala" % "sbt-scalajs-crossproject" % "1.3.2")

val batikVersion = "1.18"
libraryDependencies += "de.rototor.snuggletex" % "snuggletex-core" % "1.3.0"
libraryDependencies += "org.apache.xmlgraphics" % "batik" % batikVersion
libraryDependencies += "org.apache.xmlgraphics" % "batik-transcoder" % batikVersion
libraryDependencies += "org.apache.xmlgraphics" % "batik-codec" % batikVersion
libraryDependencies += "net.sf.saxon" % "saxon" % "8.7"
