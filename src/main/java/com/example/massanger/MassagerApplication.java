package com.example.massanger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import java.security.NoSuchAlgorithmException;

@SpringBootApplication
public class MassagerApplication {



    @Bean
    public Cipher cipher() throws NoSuchPaddingException, NoSuchAlgorithmException {
        return Cipher.getInstance("Blowfish");
    }

    public static void main(String[] args){
        SpringApplication.run(MassagerApplication.class, args);
    }

}
