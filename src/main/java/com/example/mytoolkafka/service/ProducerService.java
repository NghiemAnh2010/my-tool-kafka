package com.example.mytoolkafka.service;

import com.example.mytoolkafka.Kafka.JsonKafkaProducer;
import com.example.mytoolkafka.Kafka.KafkaProducer;
import com.example.mytoolkafka.payload.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {
        @Autowired
        private KafkaProducer kafkaProducer;
        @Autowired private JsonKafkaProducer kafkaProducerJson;

        public ResponseEntity<String> publishS(String message) {
                kafkaProducer.sendMessage(message);
                return  ResponseEntity.ok("Message sent to the topic success !!!");
        }

        public ResponseEntity<String> jsonPublishS(User data){
                kafkaProducerJson.sendMessageJson(data);
                return ResponseEntity.ok("Message sent to the topic with JsonObj !!! ");
        }
}
