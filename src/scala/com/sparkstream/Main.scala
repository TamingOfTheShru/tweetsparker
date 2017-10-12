package com.sparkstream

import org.apache.spark._
import org.apache.spark.SparkContext._
import org.apache.spark.streaming._
import org.apache.spark.streaming.twitter._
import org.apache.spark.streaming.StreamingContext._
import Utilities._

object StreamTweets {

  def main(args: Array[String]) {

    setupTwitter() // Configure Twitter credentials using twitter.txt
    
    val ssc = new StreamingContext("local[*]", "PrintTweets", Seconds(60))

    // Create a DStream from Twitter using our streaming context
    val tweets = TwitterUtils.createStream(ssc, None)
    
    // Now extract the text of each status update into RDD's using map()
    val statuses = tweets.map(status => status.getText())
    
    // Print out the first ten
    statuses.print()
    
    // Kick it all off
    ssc.start()
    ssc.awaitTermination()
  }  
}