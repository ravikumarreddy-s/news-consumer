package com.abc.news.consumer.service;

import com.abc.news.consumer.model.RssFeed;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaRssConsumer {


    @Autowired
    private RedisService redisService;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = "nyt.rss.articles", groupId = "news-consumer-group")
    public void consume(String message, @Header(value = KafkaHeaders.RECEIVED_KEY, required = false) String key) {
        try {
            RssFeed.Item article = objectMapper.readValue(message, RssFeed.Item.class);
            redisService.save(key,objectMapper.writeValueAsString(article));
            log.info("Received Article Key: {} and Title: {}",key,article.getTitle() );
        } catch (JsonProcessingException e) {
            log.error("Failed to parse message:{}",message);
            System.err.println("Failed to parse message: " + message);
        }
    }
}
