package com.learn.producer.news.config;


import com.learn.producer.news.constant.Constants;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {


    @Bean
    public NewTopic topicBuilder() {
        return TopicBuilder.name(Constants.TOPIC_NAME).build();
    }
}
