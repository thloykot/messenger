package com.example.massanger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;

@Value
public class ResponseMassage implements Serializable {

    String massage;

    public ResponseMassage(@JsonProperty("massage") String massage) {
        this.massage = massage;
    }
}
