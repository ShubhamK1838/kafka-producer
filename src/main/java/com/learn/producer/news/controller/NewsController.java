package com.learn.producer.news.controller;


import com.learn.producer.news.service.NewsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/news")
public class NewsController {

    Logger logger = LoggerFactory.getLogger(NewsController.class);


    @Autowired
    private NewsService newsService;

    @PostMapping("/update")
    public ResponseEntity<?> produceNews(@RequestBody String update) {
        newsService.produceNews(update);
        return ResponseEntity.ok().build();
    }
}
