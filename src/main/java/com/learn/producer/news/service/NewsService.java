package com.learn.producer.news.service;


import com.learn.producer.news.constant.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class NewsService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void produceNews(String message) {
        kafkaTemplate.send(Constants.TOPIC_NAME, message);
    }

}
