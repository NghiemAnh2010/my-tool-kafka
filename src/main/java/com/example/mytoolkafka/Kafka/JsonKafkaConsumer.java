package com.example.mytoolkafka.Kafka;

import com.example.mytoolkafka.logic.CheckLoginLogic;
import com.example.mytoolkafka.payload.User;
import com.example.mytoolkafka.payload.UserRes;
import com.example.mytoolkafka.repository.LoginRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {

    @Autowired private CheckLoginLogic checkLoginLogic;
//    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);
//    @KafkaListener(topics = "topic-nbqa-json", groupId = "myGroupNew")
//   public void consumer0(UserRes user){
////        LOGGER.info(String.format("Json message recieved -> %s", user.toString()));
//        System.out.println("Json message recieved by consumer 0 = " + user);
//    }
//
//    @KafkaListener(topics = "topic-nbqa-json",groupId = "myGroupNew")
//    public void consumer1(UserRes userRes){
//        System.out.println("Json message recieved by consumer 1 = " + userRes);
//    }
//
//    @KafkaListener(topics = "topic-nbqa-json",groupId = "myGroupNew")
//    public void consumer2(UserRes userRes){
//        System.out.println("Json message recieved by consumer 2 = " + userRes);
//    }

    @KafkaListener(topics = "check-login",groupId = "group-consumer-login-1")
    public void consumerLogin1(String userName){
        checkLoginLogic.saveMessageLogin(userName);
        System.out.println("Message check user login by comsumer 1 : "+userName);
    }
    @KafkaListener(topics = "check-login",groupId = "group-consumer-login-1")
    public void consumerLogin2(String userName){
        checkLoginLogic.saveMessageLogin(userName);
        System.out.println("Message check user login by comsumer 2 : "+userName);
    }
    @KafkaListener(topics = "check-login",groupId = "group-consumer-login-1")
    public void consumerLogin3(String userName){
        checkLoginLogic.saveMessageLogin(userName);
        System.out.println("Message check user login by comsumer 3 : "+userName);
    }
}
