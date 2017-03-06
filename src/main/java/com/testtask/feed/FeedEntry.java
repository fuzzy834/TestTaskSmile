package com.testtask.feed;

import com.testtask.model.News;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vitalii on 3/6/2017.
 */
public class FeedEntry {

    private final List<News> newsList = new ArrayList<>();

    void add(News news){
        newsList.add(news);
    }

    List<News> getAll(){
        newsList.sort((n1, n2) -> n1.getDateTime().compareTo(n2.getDateTime()));
        return newsList;
    }

}
