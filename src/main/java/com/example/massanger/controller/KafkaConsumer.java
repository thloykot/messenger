package com.example.massanger.controller;


import com.example.massanger.model.Massage;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import static com.example.massanger.service.impl.KafkaProducerImpl.TOPIC;


@Controller
@RequiredArgsConstructor
public class KafkaConsumer {

    private final SimpMessagingTemplate messagingTemplate;

    @KafkaListener(topics = TOPIC)
    public void consumeFromTopic(Massage massage) {
        messagingTemplate.convertAndSend("/topic/massages", massage);
    }
}
