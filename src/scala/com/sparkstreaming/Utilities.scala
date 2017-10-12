
package com.sparkstreaming

import java.util.regex.Pattern
import java.util.regex.Matcher

object Utilities {
  
  /** Configures Twitter service credentials using twiter.txt*/
  def setupTwitter() = {
    import scala.io.Source
    
    for (line <- Source.fromFile("../twitter.txt`").getLines) {
      val fields = line.split(" ")
      if (fields.length == 2) {
        System.setProperty("twitter4j.oauth." + fields(0), fields(1))
      }
    }
  }
}

