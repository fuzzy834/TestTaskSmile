package com.testtask.feed;

/**
 * Created by Vitalii on 3/6/2017.
 */
class France24FeedEN extends FeedReader{

    private static final String FEED_URL = "http://www.france24.com/en/france/rss";

    private static France24FeedEN instance;

    private France24FeedEN() {
        super(FEED_URL);
        this.laguage = "en";
        this.feedEntry = new FeedEntry();
        this.readFeed();
    }

    public static France24FeedEN getInstance(){
        return (instance == null)?(instance = new France24FeedEN()):instance;
    }
}
