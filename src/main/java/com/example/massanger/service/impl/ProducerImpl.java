package com.example.massanger.service.impl;

import com.example.massanger.model.Massage;
import com.example.massanger.service.Producer;
import com.example.massanger.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;


@Service
@RequiredArgsConstructor
public class ProducerImpl implements Producer {

    public static final String TOPIC = "MassagerTopic";

    private final KafkaTemplate<String, Massage> kafkaTemplate;

    @Override
    public void publishTopic(String token,String message) {
        String usersMassage = new String(Base64.getDecoder().decode(message.getBytes(StandardCharsets.UTF_8)));
        String username = token.split(":")[0];
        Massage userMassage = new Massage(usersMassage,username);
        kafkaTemplate.send(TOPIC, userMassage);
    }
}
