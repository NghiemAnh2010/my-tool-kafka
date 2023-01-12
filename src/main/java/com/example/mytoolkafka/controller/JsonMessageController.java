package com.example.mytoolkafka.controller;

import com.example.mytoolkafka.payload.UserReq;
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

    @PostMapping("/publish-login")
    public ResponseEntity<String> publish (@RequestBody UserReq userReq){
        return producerService.publishDataLogin(userReq);
    }
}
