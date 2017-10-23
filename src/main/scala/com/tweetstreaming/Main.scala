package com.tweetstreaming

import org.apache.spark._
import org.apache.spark.SparkContext._
import twitter4j._
import twitter4j.conf._
import twitter4j.json._
import org.apache.log4j.Level
/*import org.apache.spark.streaming._
import org.apache.spark.streaming.twitter._
import org.apache.spark.streaming.StreamingContext._ */
import Utilities._

object Stream extends RawStreamListener {
  setupLogging()

  def main(args: Array[String]): Unit = {
    val twitterStream = new TwitterStreamFactory(Utilities.config).getInstance()
    twitterStream.addListener(this)
    twitterStream.filter(new FilterQuery().track(args))
    Thread.sleep(5000)
    twitterStream.cleanUp
    twitterStream.shutdown
  }
  def onMessage(rawString: String): Unit = {
    System.out.println(rawString)
  }
  def onException(ex: Exception): Unit = {
    ex.printStackTrace()
  }
}

/*object StreamTweets {

  def main(args: Array[String]) {
    val twitterStream = new TwitterStreamFactory(Utilities.config).getInstance
    twitterStream.addListener(Utilities.simpleStatusListener)
    twitterStream.sample
    Thread.sleep(5000)
    twitterStream.cleanUp
    twitterStream.shutdown
  }
}

object StreamTweetsByLocation {

  def main(args: Array[String]) {
    val twitterStream = new TwitterStreamFactory(Utilities.config).getInstance
    twitterStream.addListener(Utilities.simpleStatusListener)
    twitterStream.filter(new FilterQuery(Array(1344951, 5988062, 807095, 3108351)))
    Thread.sleep(10000)
    twitterStream.cleanUp
    twitterStream.shutdown
  }
}

object StreamTweetsBySearchCriteria {

  def main(args: Array[String]) {
    val twitterStream = new TwitterStreamFactory(Utilities.config).getInstance
    twitterStream.addListener(Utilities.simpleStatusListener)
    twitterStream.filter(new FilterQuery().track(args))
    Thread.sleep(20000)
    twitterStream.cleanUp
    twitterStream.shutdown
  }
}*/
