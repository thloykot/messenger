package com.example.massanger.service;


public interface KafkaProducer {

    void publishTopic(String token, String massage);
}
