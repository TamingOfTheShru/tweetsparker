package com.tweetstreaming

import org.apache.spark._
import org.apache.spark.SparkContext._
import twitter4j._
/*import org.apache.spark.streaming._
import org.apache.spark.streaming.twitter._
import org.apache.spark.streaming.StreamingContext._ */
import Utilities._

object StreamTweets {

  def main(args: Array[String]) {
    println(Utilities.config)
    
    val twitterStream = new TwitterStreamFactory(Utilities.config).getInstance
    twitterStream.addListener(Utilities.simpleStatusListener)
    twitterStream.sample
    Thread.sleep(5000)
    twitterStream.cleanUp
    twitterStream.shutdown

  }
}