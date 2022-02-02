package com.example.massanger.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Massage {
    private String massage;
    private String username;

    @Override
    public String toString() {
        return username + ":" + massage;
    }
}
