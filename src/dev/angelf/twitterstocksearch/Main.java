package dev.angelf.twitterstocksearch;

import dev.angelf.twitterstocksearch.twitter.TwitterBot;
import dev.angelf.twitterstocksearch.twitter.TwitterCredentials;

public class Main {

    public static void main(String[] args) {
        // Create a Scanner Program
        TestRun();
    }

    private static void TestRun() {
        // Initial Test ===================================================
        // ADD Your Twitter API Credentials
        TwitterCredentials credentials = new TwitterCredentials();
        credentials.ACCESS_TOKEN = "";
        credentials.ACCESS_TOKEN_SECRET = "";
        credentials.CONSUMER_API_KEY = "";
        credentials.CONSUMER_API_SECRET_KEY = "";

        // Construct a TwitterBot
        TwitterBot twitterBot = new TwitterBot(credentials);

        // Gather tweets
        String[] tweets = twitterBot.getTweetArray("TSLA");

        // Count the amount of times the stock is mentioned.

        // Count the words used in the tweets gathered excluding the stock ticker

        // Provide option to save the data files.
    }

}
