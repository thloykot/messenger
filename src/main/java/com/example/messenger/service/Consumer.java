package com.example.messenger.service;

import com.example.messenger.model.Massage;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static com.example.messenger.kafka.KafkaUtils.GROUP_ID;
import static com.example.messenger.kafka.KafkaUtils.TOPIC;


@Service
public class Consumer {

    @KafkaListener(topics = TOPIC, containerFactory = "kafkaListenerContainerFactory", groupId = GROUP_ID)
    public String consumeFromTopic(Massage massage) {
        System.out.println(massage);
        return massage.toString();
    }
}
