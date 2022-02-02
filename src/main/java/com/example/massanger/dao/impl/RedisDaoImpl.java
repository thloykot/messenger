package com.example.massanger.dao.impl;


import com.example.massanger.dao.RedisDao;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class RedisDaoImpl implements RedisDao {

    private final HashOperations<String, String, String> hashOperations;
    private static final String USER = "USER";

    public RedisDaoImpl(RedisTemplate<String, String> RedisTemplate) {
        this.hashOperations = RedisTemplate.opsForHash();
    }

    @Override
    public void save(String token, String username) {
        hashOperations.put(USER, token, username);
    }

    @Override
    public Optional<String> getUsername(String token) {
        return Optional.ofNullable(hashOperations.get(USER, token));
    }

    @Override
    public void deleteUser(String token) {
        hashOperations.delete(USER, token);
    }
}
