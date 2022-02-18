package com.example.massanger.service.impl;

import com.example.massanger.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;

@Service
@RequiredArgsConstructor
public class TokenServiceImpl implements TokenService {

    private static final String KEY = "KEY";//env
    private final Cipher cipher;//side effect
    private final SecretKeySpec keySpec = new SecretKeySpec(KEY.getBytes(), "Blowfish");

    @Override
    public String encode(String name) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        cipher.init(Cipher.ENCRYPT_MODE, keySpec);
        byte[] hasil = cipher.doFinal((name + ":" + ZonedDateTime.now(ZoneOffset.UTC)
                .format(DateTimeFormatter.ISO_DATE)).getBytes());
        return new String(Base64.getEncoder().encode(hasil));
    }

    @Override
    public String decode(String token) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        cipher.init(Cipher.DECRYPT_MODE, keySpec);
        return new String(cipher.doFinal(Base64.getDecoder().decode(token.getBytes())),StandardCharsets.UTF_8);
    }
}
