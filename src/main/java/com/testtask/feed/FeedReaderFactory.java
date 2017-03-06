package com.testtask.feed;

/**
 * Created by Vitalii on 3/6/2017.
 */
public class FeedReaderFactory {

    private FeedReaderFactory() {
    }

    public static FeedReader getInstance(String locale){
        FeedReader feedReader = null;
        switch (locale){
            case "en":
                feedReader = France24FeedEN.getInstance();
                break;
            case "fr":
                feedReader = France24FeedFR.getInstance();
                break;
        }
        return feedReader;
    }
}
