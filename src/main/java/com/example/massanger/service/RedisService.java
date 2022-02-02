package com.example.massanger.service;

import com.example.massanger.model.UserForm;

public interface RedisService {

    void save(UserForm form);

    String getUsername(String token) throws Exception;

    void deleteUser(String userName);

    boolean isUserPresent(String token);
}
