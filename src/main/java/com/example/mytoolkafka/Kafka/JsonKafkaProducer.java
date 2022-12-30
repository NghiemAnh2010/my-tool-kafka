package com.example.mytoolkafka.Kafka;

import com.example.mytoolkafka.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaProducer {

    @Autowired private KafkaTemplate<String,User> kafkaTemplate;

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);

    public void sendMessageJson(User data){
        LOGGER.info(String.format("Message sent to topic %s",data.toString()));
        Message<User> message = MessageBuilder
                .withPayload(data)
                .setHeader(KafkaHeaders.TOPIC,"topic-nbqa-json")
                .build();
        kafkaTemplate.send(message);
    }

}
