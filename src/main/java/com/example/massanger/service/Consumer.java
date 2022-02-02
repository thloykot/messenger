package com.example.massanger.service;


import com.example.massanger.model.Massage;

public interface Consumer {

    String consumeFromTopic(Massage massage);
}
