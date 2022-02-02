package com.example.massanger.service;


import com.example.massanger.model.Massage;

public interface Producer {

    void publishTopic(Massage massage);
}
