package com.testtask.controllers;

import com.testtask.feed.FeedReader;
import com.testtask.feed.FeedReaderFactory;
import com.testtask.model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Vitalii on 3/4/2017.
 */
@Controller
public class NewsController {

    private static final String EMAIL = "vtyshchukmail@gmail.com";

    @Autowired
    private JavaMailSender mailSender;

    @GetMapping("/")
    public ModelAndView news(){
        FeedReader feedReader = FeedReaderFactory.getInstance
                (
                LocaleContextHolder
                        .getLocale()
                        .toLanguageTag()
                        .toLowerCase()
                );
        List<News> news = feedReader.getFeed();
        List<News> newsToDisplay = news.size()>3?news.subList(0,3):news;


        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.getModelMap().addAttribute("news", newsToDisplay);

        return modelAndView;
    }

    @GetMapping("/contact")
    public String contact(){
        return "contact";
    }

    @PostMapping("/contact")
    public String send(@RequestParam String subject, @RequestParam String message){
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(EMAIL);
        email.setSubject(subject);
        email.setText(message);
        mailSender.send(email);
        return "redirect:contact";
    }
}
