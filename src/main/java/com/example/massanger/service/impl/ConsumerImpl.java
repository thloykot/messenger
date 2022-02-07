package com.example.massanger.service.impl;



import com.example.massanger.model.Massage;
import com.example.massanger.service.Consumer;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.example.massanger.service.impl.ProducerImpl.TOPIC;


@Service
public class ConsumerImpl implements Consumer {

    private List<Massage> massages = new ArrayList<>();

    @Override
    @KafkaListener(topics = TOPIC)
    public String consumeFromTopic(Massage massage) {
        massages.add(massage);
        return massage.toString();
    }

    @Override
    public List<Massage> getMassages() {
        return massages;
    }
}
