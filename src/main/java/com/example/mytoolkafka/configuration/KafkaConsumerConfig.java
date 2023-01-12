package com.example.mytoolkafka.configuration;

import com.example.mytoolkafka.payload.UserRes;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// Anotation @EnableKafka được dùng để detect (phát hiện) các anotation @KafkaListener
@EnableKafka
@Configuration
public class KafkaConsumerConfig {

    @Value("localhost:9092")
    private String bootstrapServers;

    // Method consumerFactory này để cấu hình Kafka
    @Bean
    public ConsumerFactory<String, String> consumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,bootstrapServers);
        // Đây là các ta đặt tên ConsumerGroup
        props.put(ConsumerConfig.GROUP_ID_CONFIG,"group-consumer-login-1");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        // Số message tối đa được trả về trong 1 lần gọi hàn poll()
        props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG,1000);
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG,true);


        return new DefaultKafkaConsumerFactory<>(props);
    }

    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, String>> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String,String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }
}

// Sau khi có class KafkaConsumerConfig này thì muốn consume 1 topic nào đó thì ta chỉ cần sử dụng anotation @KafkaListener
//  VD:
        //    @KafkaListener(topics = "demo", groupId = "group-id")
        //    public void listen(String message) {
        //        System.out.println("Received Message in group - group-id: " + message);
        //    }
