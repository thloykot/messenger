package com.example.messenger.controller;

import com.example.messenger.model.Massage;
import com.example.messenger.service.Producer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MassagerController {

    private final Producer producer;

    @PostMapping("/post")
    public ResponseEntity<String> sendMassage(@RequestParam("msg") String massage, @RequestParam("usr") String username) {
        producer.publishTopic(new Massage(massage, username));
        return ResponseEntity.ok("Sending message");
    }
}
