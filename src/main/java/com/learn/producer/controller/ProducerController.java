package com.learn.producer.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ProducerController {

    Logger logger = LoggerFactory.getLogger(ProducerController.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping("/produce")
    public void sendMessage(@RequestBody Map<String, String> message) {
        for (Map.Entry<String, String> entry : message.entrySet()) {
            var a = kafkaTemplate.send(entry.getKey(), entry.getValue());
            logger.info("Message sent to topic: " + entry.getKey() + " : " + entry.getValue());
        }
    }
}
