package com.example.massanger.controller;


import com.example.massanger.model.Massage;
import com.example.massanger.model.ResponseMassage;
import com.example.massanger.model.UserForm;
import com.example.massanger.service.Consumer;
import com.example.massanger.service.Producer;
import com.example.massanger.service.RedisService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class MassagerController {

    private final Producer producer;
    private final Consumer consumer;
    private final RedisService redisService;

    @PostMapping("/post")
    public ResponseEntity<ResponseMassage> sendMassage(@RequestBody Massage message) {
        producer.publishTopic(message);
        return ResponseEntity.ok(new ResponseMassage("Sending message"));
    }

    @PutMapping(value = "/registration", produces = "application/json")
    public ResponseEntity<ResponseMassage> registerUser(@RequestBody UserForm form) {
        redisService.save(form);
        return ResponseEntity.ok(new ResponseMassage("Success"));
    }

    @PostMapping("/test")
    public ResponseEntity<ResponseMassage> test() {
        return ResponseEntity.ok(new ResponseMassage("test"));
    }
}
