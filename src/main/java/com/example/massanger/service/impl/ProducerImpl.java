package com.example.massanger.service.impl;

import com.example.massanger.model.Massage;
import com.example.massanger.service.Producer;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ProducerImpl implements Producer {

    public static final String TOPIC = "MassagerTopic";

    private final KafkaTemplate<String, Massage> kafkaTemplate;

    @Override
    public void publishTopic(Massage massage) {
        kafkaTemplate.send(TOPIC, massage);
    }
}
