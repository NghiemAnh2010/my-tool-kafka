package com.example.mytoolkafka.Kafka;

import com.example.mytoolkafka.payload.UserRes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaProducer {

    @Autowired private KafkaTemplate<String, UserRes> kafkaTemplateJson;

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);

    public void sendMessageJson(String topic,UserRes userRes){
//        LOGGER.info(String.format("Message sent to topic %s",userRes.toString()));
        kafkaTemplateJson.send(topic,userRes);
    }

}
