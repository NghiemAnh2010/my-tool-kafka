package com.example.mytoolkafka.service;

import com.example.mytoolkafka.Kafka.JsonKafkaProducer;
import com.example.mytoolkafka.Kafka.KafkaProducer;
import com.example.mytoolkafka.entity.DtbLogin;
import com.example.mytoolkafka.logic.CheckLoginLogic;
import com.example.mytoolkafka.payload.UserReq;
import com.example.mytoolkafka.payload.UserRes;
import com.example.mytoolkafka.repository.LoginRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProducerService {
        @Autowired
        private KafkaProducer kafkaProducer;
        @Autowired private JsonKafkaProducer kafkaProducerJson;
        @Autowired private CheckLoginLogic checkLoginLogic;
        @Autowired private LoginRepository loginRepository;
        private static final ModelMapper modelMapper = new ModelMapper();

        public ResponseEntity<String> publishS(String message) {
                kafkaProducer.sendMessage(message);
                return  ResponseEntity.ok("Message sent to the topic success !!!");
        }

//        public ResponseEntity<String> jsonPublishS(UserReq data){
//                kafkaProducerJson.sendMessageJson(data);
//                return ResponseEntity.ok("Message sent to the topic with JsonObj !!! ");
//        }
        public ResponseEntity<String> publishDataLogin (UserReq userReq){
                String topic = "topic-nbqa-json";
                UserRes userRes = new UserRes();
                userRes.setUsername(userReq.getUserName());
//                userRes.setPassword(userReq.getPassword());
                kafkaProducerJson.sendMessageJson(topic,userRes);
                return ResponseEntity.ok("Message sent to the topic success !!!");
        }

      public ResponseEntity<List<UserRes>> getAllNumberLoginMoreThanTwice(){
              // 1 Là phải lấy ra được tất cả các username có số lần login > 2
              // 2 Phải sắp xếp các
              List<UserRes> userRes = loginRepository.findAllByNubmerLogin();
              return ResponseEntity.ok(userRes);
      }
}
