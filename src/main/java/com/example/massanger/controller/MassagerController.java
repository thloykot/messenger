package com.example.massanger.controller;


import com.example.massanger.model.ResponseMassage;
import com.example.massanger.model.UserForm;
import com.example.massanger.service.KafkaProducer;
import com.example.massanger.service.TokenService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RequiredArgsConstructor
@Controller
public class MassagerController {

    private final KafkaProducer kafkaProducer;
    private final TokenService tokenService;


    @PostMapping("/post")
    public ResponseEntity<Void> sendMassage(@RequestBody ResponseMassage message, HttpServletRequest request) {
        try {
            kafkaProducer.publishTopic(tokenService.decode(request.getHeader("Token")), message.getMassage());
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }

    }

    @PutMapping(value = "/registration", produces = "application/json")
    public ResponseEntity<Void> registerUser(@RequestBody UserForm form, HttpServletResponse response) {
        try {
            response.addHeader("Token", tokenService.encode(form.getUsername()));
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

}
