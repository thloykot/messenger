package com.example.massanger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Value
public class UserForm {//final
    String username;

    public UserForm(@JsonProperty("username") String username) {
        this.username = username;
    }
}
