name := "batt"

description := "Benchmark All The Things"

organization := "com.pwootage"

version := "0.0.1"

scalaVersion := "2.11.2"

managedSourceDirectories in Compile ++= Seq(
  baseDirectory.value / "src" / "main" / "scala",
  baseDirectory.value / "src" / "main" / "java"
)

managedResourceDirectories in Compile ++= Seq(
  baseDirectory.value / "src" / "main" / "resources"
)