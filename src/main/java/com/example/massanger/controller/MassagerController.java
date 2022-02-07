package com.example.massanger.controller;


import com.example.massanger.model.Massage;
import com.example.massanger.model.ResponseMassage;
import com.example.massanger.model.UserForm;
import com.example.massanger.service.Consumer;
import com.example.massanger.service.Producer;
import com.example.massanger.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class MassagerController {

    private final Producer producer;
    private final Consumer consumer;
    private final TokenService tokenService;


    @PostMapping("/post")
    public ResponseEntity<ResponseMassage> sendMassage(@RequestBody ResponseMassage message, HttpServletRequest request) {
        producer.publishTopic(tokenService.decode(request.getHeader("Token")),message.getMassage());
        return ResponseEntity.ok(new ResponseMassage("Sending message"));
    }

    @PutMapping(value = "/registration", produces = "application/json")
    public ResponseEntity<ResponseMassage> registerUser(@RequestBody UserForm form, HttpServletResponse response) {
        response.addHeader("Token", tokenService.encode(form.getUsername()));
        return ResponseEntity.ok(new ResponseMassage());
    }

    @PostMapping("/test")
    public ResponseEntity<ResponseMassage> test() {
        return ResponseEntity.ok(new ResponseMassage("test"));
    }

    @GetMapping("/massages")
    public ResponseEntity<List<Massage>> getMassages() {
        return ResponseEntity.ok(consumer.getMassages());
    }
}
