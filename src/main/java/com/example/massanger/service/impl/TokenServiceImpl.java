package com.example.massanger.service.impl;

import com.example.massanger.service.TokenService;
import lombok.AllArgsConstructor;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;

@Service
@AllArgsConstructor
public class TokenServiceImpl implements TokenService {

    @Override
    public String encode(String name) {
        return Base64.getEncoder()
                .encodeToString((name + ":" + ZonedDateTime.now(ZoneOffset.UTC).format(DateTimeFormatter.ISO_DATE)).getBytes(StandardCharsets.UTF_8));
    }

    @Override
    public String decode(String token) {
        return new String(Base64.getDecoder().decode(token)).split(":")[0];
    }

}
