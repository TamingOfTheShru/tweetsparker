name := "tweetsparker"

version := "0.1"

scalaVersion := "2.11.8"

libraryDependencies += "org.apache.spark" %% "spark-core" % "2.2.0" 
/*libraryDependencies += "org.apache.spark" %% "spark-streaming" % "2.0.1"
libraryDependencies += "org.apache.spark" % "spark-streaming-twitter_2.11" % "2.0.1"*/
libraryDependencies += "org.twitter4j" % "twitter4j-stream" % "3.0.3"
libraryDependencies += "org.apache.log4j"
/*libraryDependencies += "org.twitter4j" % "twitter4j-conf" % "3.0.3"
libraryDependencies += "org.twitter4j" % "twitter4j-json" % "3.0.3"*/