package dev.angelf.twitterstocksearch.twitter;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterBot {

    private final Twitter twitter;

    public TwitterBot(TwitterCredentials credentials) {
        ConfigurationBuilder cb = new ConfigurationBuilder();

        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(credentials.CONSUMER_API_KEY)
                .setOAuthConsumerSecret(credentials.CONSUMER_API_SECRET_KEY)
                .setOAuthAccessToken(credentials.ACCESS_TOKEN)
                .setOAuthAccessTokenSecret(credentials.ACCESS_TOKEN_SECRET);

        cb.setJSONStoreEnabled(true);

        TwitterFactory tf = new TwitterFactory(cb.build());
        twitter = tf.getInstance();
    }

    public String[] getTweetArray(String stockTicker) {
        try {
            //Adjust Stock Ticker and set Query
            Query query = new Query("$" + stockTicker);
            query.setLang("en");
            query.setCount(100);

            //Get Results
            QueryResult queryResult = twitter.search(query);

            //Build Array
            int count = queryResult.getTweets().size();
            String[] queryArray = new String[count];

            for (int i = 0; i < count; i++) {
                String s = queryResult.getTweets().get(i).toString();
                queryArray[i] = s;
            }

            return queryArray;
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Error gathering tweets: make sure that your Twitter API credentials are set correctly.");
            System.exit(-1); // Exit Program
            return null;
        }
    }

}
