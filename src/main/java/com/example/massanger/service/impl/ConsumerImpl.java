package com.example.massanger.service.impl;



import com.example.massanger.model.Massage;
import com.example.massanger.service.Consumer;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static com.example.massanger.service.impl.ProducerImpl.TOPIC;


@Service
public class ConsumerImpl implements Consumer {

    @Override
    @KafkaListener(topics = TOPIC)
    public String consumeFromTopic(Massage massage) {
        System.out.println(massage);
        return massage.toString();
    }
}
