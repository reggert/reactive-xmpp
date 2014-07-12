name := "reactive-xmpp"

organization := "io.github.reggert" 

version := "0.0.1-SNAPSHOT"

scalaVersion := "2.11.1"

scalacOptions += "-unchecked"

scalacOptions += "-deprecation"

scalacOptions += "-feature"

libraryDependencies += "org.igniterealtime.smack" % "smack-core" % "4.0.0"

libraryDependencies += "org.igniterealtime.smack" % "smack-tcp" % "4.0.0"

libraryDependencies += "org.igniterealtime.smack" % "smack-extensions" % "4.0.0"

libraryDependencies += "com.netflix.rxjava" % "rxjava-scala" % "0.19.2"

libraryDependencies += "com.typesafe.scala-logging" %% "scala-logging-slf4j" % "2.1.2"

libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.1.2" % "runtime"

libraryDependencies += "org.slf4j" % "jcl-over-slf4j" % "1.7.7" % "runtime"

libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.11.4" % "test"

libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.0" % "test"

 

