package com.example.massanger.service;


import com.example.massanger.model.Massage;

import java.util.List;

public interface Consumer {

    String consumeFromTopic(Massage massage);

    List<Massage> getMassages();
}
