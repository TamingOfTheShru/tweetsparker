package com.sparkstreaming

import org.apache.spark._
import org.apache.spark.SparkContext._
import org.apache.spark.streaming._
import org.apache.spark.streaming.twitter._
import org.apache.spark.streaming.StreamingContext._
import Utilities._

object StreamTweets {
 
  def main(args: Array[String]) {

    setupTwitter()
    
    val ssc = new StreamingContext("local[*]", "StreamTweets", Seconds(60))

    val tweets = TwitterUtils.createStream(ssc, None)
    
    val statuses = tweets.map(status => status.getText())
    
    statuses.print()
    
    ssc.start() // Start
    ssc.awaitTermination()
  }  
}