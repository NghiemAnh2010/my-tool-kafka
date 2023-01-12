package com.example.mytoolkafka.controller;

import com.example.mytoolkafka.payload.UserReq;
import com.example.mytoolkafka.payload.UserRes;
import com.example.mytoolkafka.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/kafka")
public class MessageController {

    @Autowired
    private ProducerService producerService;

    // http://localhost:8080/api/v1/kafka/publish?message= ...
    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message){
//        kafkaProducer.sendMessage(message);
        return producerService.publishS(message);
    }

    @GetMapping("/number-login")
    public ResponseEntity<List<UserRes>> getAllNumberLoginMoreThanTwice(){
        return producerService.getAllNumberLoginMoreThanTwice();
    }
//    @PostMapping("/json-publish")
//    public ResponseEntity<UserReq> jsonPublish(@RequestBody UserReq user){
//        return producerService.jsonPublishS(user);
//    }
}
