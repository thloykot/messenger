package com.example.messenger.service;

import com.example.messenger.model.Massage;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import static com.example.messenger.kafka.KafkaUtils.TOPIC;

@Service
@RequiredArgsConstructor
public class Producer {

    private final KafkaTemplate<String, Massage> kafkaTemplate;

    public void publishTopic(Massage massage) {
        kafkaTemplate.send(TOPIC,massage);
    }
}
