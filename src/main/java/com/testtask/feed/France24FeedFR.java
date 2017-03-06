package com.testtask.feed;

/**
 * Created by Vitalii on 3/6/2017.
 */
class France24FeedFR extends FeedReader{

    private static final String FEED_URL = "http://www.france24.com/fr/france/rss";

    private static France24FeedFR instance;

    private France24FeedFR() {
        super(FEED_URL);
        this.laguage = "fr";
        this.feedEntry = new FeedEntry();
        this.readFeed();
    }

    public static France24FeedFR getInstance(){
        return (instance == null)?(instance = new France24FeedFR()):instance;
    }
}
