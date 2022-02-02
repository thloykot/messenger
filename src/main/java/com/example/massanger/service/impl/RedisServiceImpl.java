package com.example.massanger.service.impl;


import com.example.massanger.dao.RedisDao;
import com.example.massanger.model.UserForm;
import com.example.massanger.service.RedisService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RedisServiceImpl implements RedisService {

    private final RedisDao redisDao;

    @Override
    public void save(UserForm form) {
        redisDao.save(form.getToken(), form.getUsername());
    }

    @Override
    public String getUsername(String token) throws Exception {
        return redisDao.getUsername(token)
                .orElseThrow(() -> new Exception("User not found"));
    }

    @Override
    public void deleteUser(String userName) {
        redisDao.deleteUser(userName);
    }

    @Override
    public boolean isUserPresent(String token) {
        return redisDao.getUsername(token).isPresent();
    }
}
