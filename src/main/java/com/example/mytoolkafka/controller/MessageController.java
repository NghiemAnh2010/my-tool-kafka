package com.example.mytoolkafka.controller;

import com.example.mytoolkafka.payload.User;
import com.example.mytoolkafka.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

//    @PostMapping("/json-publish")
//    public ResponseEntity<User> jsonPublish(@RequestBody User user){
//        return producerService.jsonPublishS(user);
//    }
}
