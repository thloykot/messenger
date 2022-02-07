package com.example.massanger.service;

public interface TokenService {

    String encode(String name);

    String decode(String token);
}
