package com.example.massanger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Value
public class Massage {
    String massage, username;

    @Override
    public String toString() {
        return username + ":" + massage;
    }

    public Massage(@JsonProperty("massage") String massage, @JsonProperty("username") String username) {
        this.massage = massage;
        this.username = username;
    }
}
