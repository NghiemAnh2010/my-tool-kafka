package com.example.mytoolkafka.controller;

import com.example.mytoolkafka.Kafka.JsonKafkaProducer;
import com.example.mytoolkafka.payload.User;
import com.example.mytoolkafka.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/kafka")
public class JsonMessageController {

    @Autowired
    private ProducerService producerService;

    @PostMapping("/publish")
    public ResponseEntity<String> publish (@RequestBody User data){
        return producerService.jsonPublishS(data);
    }
}
