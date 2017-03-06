package com.testtask.feed;

import com.testtask.model.News;
import java.util.List;

/**
 * Created by Vitalii on 3/6/2017.
 */
public class MainTest {

    public static void main(String[] args) {

        for (News news : FeedReaderFactory.getInstance("fr").getFeed()){
            System.out.println("--------------------------------------");
            System.out.println(news.getTitle());
            System.out.println(news.getLocation());
            System.out.println(news.getImageLink());
            System.out.println(news.getLink());
            System.out.println(news.getLanguage());
            System.out.println(news.getDateTime());
            System.out.println(news.getContent());
            System.out.println("--------------------------------------");
        }
    }
}
