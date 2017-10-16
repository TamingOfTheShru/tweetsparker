package com.tweetstreaming

import twitter4j._

object Utilities {
  val config = new twitter4j.conf.ConfigurationBuilder()
    .setOAuthConsumerKey("PPqpEBWw2nrf7OFjQvNsYnkZs")
    .setOAuthConsumerSecret("QtbM1gjZTJFEgvPU1GG3aaNwXsN510koO7QpVWNO1m3RycOFe1")
    .setOAuthAccessToken("2669812334-Eu8iJ1wON3QufIf6cczw0M5X6H4pTOZlpY9XWyk")
    .setOAuthAccessTokenSecret("cmZpPMk1750OX9JvRXdjvz8M8rstLGBxa1Q3se3GpR6t2")
    .build

  def simpleStatusListener = new StatusListener() {
  def onStatus(status: Status) { println(status.getText) }
  def onDeletionNotice(statusDeletionNotice: StatusDeletionNotice) {}
  def onTrackLimitationNotice(numberOfLimitedStatuses: Int) {}
  def onException(ex: Exception) { ex.printStackTrace }
  def onScrubGeo(arg0: Long, arg1: Long) {}
  def onStallWarning(warning: StallWarning) {}
  }
}

