name := "VMA"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache
)   

play.Project.playScalaSettings

net.litola.SassPlugin.sassSettings
