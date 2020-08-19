package dev.angelf.twitterstocksearch;

import dev.angelf.twitterstocksearch.twitter.TwitterBot;
import dev.angelf.twitterstocksearch.twitter.TwitterCredentials;

import java.util.Scanner;

public class Main {

    private static Scanner sc;
    private static boolean running;
    private static TwitterBot twitterBot;
    private static String[] tweets;

    public static void main(String[] args) {
        init();
        run();
    }

    private static void init() {
        sc = new Scanner(System.in);
        running = true;
        println(" -=- TwitterStockSearch -=- ");
        println("Powered by   : twitter4j");
        println("Developed by : angelF.dev");
        println("");
        println("type 'help' to get started.");
    }

    private static void run() {
        while (running) {
            print("Enter a command: ");
            listen(sc.nextLine());
        }
    }

    private static void listen(String command) {
        switch (command.toLowerCase()) {
            case "setup":
                setup();
                break;

            case "search":
                search();
                break;

            case "results":
                results();
                break;

            case "end":
                end();
                break;

            case "help":
                help();
                break;
        }
    }

    private static void setup() {
        print("Enter Access Token: ");
        String access_token = sc.nextLine();
        print("Enter Access Token Secret: ");
        String access_token_secret = sc.nextLine();
        print("Enter Consumer API Key: ");
        String consumer_api_key = sc.nextLine();
        print("Enter Consumer API Key Secret: ");
        String consumer_api_key_secret = sc.nextLine();

        TwitterCredentials credentials = new TwitterCredentials();
        credentials.ACCESS_TOKEN = access_token;
        credentials.ACCESS_TOKEN_SECRET = access_token_secret;
        credentials.CONSUMER_API_KEY = consumer_api_key;
        credentials.CONSUMER_API_SECRET_KEY = consumer_api_key_secret;

        println("Constructing Twitter Bot...");
        twitterBot = new TwitterBot(credentials);
        println("Ready to Search.");
    }

    public static void search() {
        if (twitterBot != null) {
            print("Enter Stock Ticker Symbol: ");
            // Clean the input and remove special characters
            tweets = twitterBot.getTweetArray(sc.nextLine());
        } else {
            println("Credentials are not set.");
        }
    }

    public static void results() {
        if (tweets != null) {
            for (String t : tweets) {
                println(t);
                println("");
            }
        } else {
            println("No tweets found in list.");
        }
    }

    private static void end() {
        running = false;
        println("Terminating Program");
        System.exit(0);
    }

    private static void help() {
        println("-- HELP --");
        println(" setup   : Enter your Twitter API Credentials.");
        println(" search  : Search Twitter for stock ticker symbol.");
        println(" results : print all tweets to console. (JSON)");
        println(" end     : Close the program.");
    }

    private static void println(Object object) {
        System.out.println(object);
    }

    private static void print(Object object) {
        System.out.print(object);
    }

}
