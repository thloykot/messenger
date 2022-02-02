package com.example.massanger.dao;

import java.util.Optional;

public interface RedisDao {

    void save(String token,String username);

    Optional<String> getUsername(String token);

    void deleteUser(String token);

}
