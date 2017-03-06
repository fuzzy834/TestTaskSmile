package com.testtask.feed;

import com.testtask.model.News;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.XMLEvent;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Vitalii on 3/6/2017.
 */
public abstract class FeedReader {

    private static final String ITEM = "item";
    private static final String TITLE = "title";
    private static final String LOCATION = "category";
    private static final String LINK = "link";
    private static final String IMAGE_LINK = "enclosure";
    private static final String CONTENT = "description";
    private static final String DATE_TIME = "pubDate";

    private URL url;

    FeedEntry feedEntry;

    String laguage;


    public FeedReader(String feedUrl) {
        try {
            this.url = new URL(feedUrl);
        }catch (MalformedURLException e){
            throw new RuntimeException(e);
        }
    }

    void readFeed(){

        String title = "";
        String location = "";
        String link = "";
        String imageLink = "";
        String content = "";
        String dateTime = "";

        try {
            boolean isFeedHeader = true;

            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            InputStream in = openStream();
            XMLEventReader eventReader = inputFactory.createXMLEventReader(in);

            while (eventReader.hasNext()) {

                XMLEvent event = eventReader.nextEvent();
                if (event.isStartElement()) {
                    String localPart = event.asStartElement().getName().getLocalPart();
                    switch (localPart) {
                        case ITEM:
                            if (isFeedHeader) {
                                isFeedHeader = false;
                            }
                            event = eventReader.nextEvent();
                            break;
                        case TITLE:
                            title = getCharacters(event, eventReader);
                            break;
                        case LOCATION:
                            location = getCharacters(event, eventReader);
                            break;
                        case LINK:
                            link = getCharacters(event, eventReader);
                            break;
                        case IMAGE_LINK:
                            Iterator<Attribute> attribue = event.asStartElement().getAttributes();
                            while(attribue.hasNext()){
                                Attribute myAttribute = attribue.next();
                                if(myAttribute.getName().toString().equals("url")){
                                    imageLink = myAttribute.getValue();
                                }
                            }
                            break;
                        case CONTENT:
                            content = getCharacters(event, eventReader);
                            break;
                        case DATE_TIME:
                            dateTime = getCharacters(event, eventReader);
                            break;
                    }
                }
                else if (event.isEndElement()) {
                    if (event.asEndElement().getName().getLocalPart().equals(ITEM)) {
                        News news = new News();
                        news.setTitle(title);
                        news.setLocation(location);
                        news.setLanguage(this.laguage);
                        news.setLink(link);
                        news.setImageLink(imageLink);
                        news.setContent(content);
                        news.setDateTime(LocalDateTime.parse(dateTime, DateTimeFormatter.RFC_1123_DATE_TIME));
                        this.feedEntry.add(news);
                        event = eventReader.nextEvent();
                    }
                }
            }
        }catch (XMLStreamException e){
            throw new RuntimeException(e);
        }
    }

    private String getCharacters(XMLEvent event, XMLEventReader eventReader) throws XMLStreamException {
        String result = "";
        event = eventReader.nextEvent();
        if (event instanceof Characters) {
            result = event.asCharacters().getData();
        }
        return result;
    }

    private InputStream openStream() {
        try {
            return url.openStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<News> getFeed(){
        return this.feedEntry.getAll();
    }

}
