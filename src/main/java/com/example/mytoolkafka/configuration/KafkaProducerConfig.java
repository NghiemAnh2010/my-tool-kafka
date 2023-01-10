package com.example.mytoolkafka.configuration;

import com.example.mytoolkafka.payload.User;
import com.example.mytoolkafka.payload.UserRes;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

// Config Producer là ok
@Configuration
public class KafkaProducerConfig {
    @Value("localhost:9092")
    private String bootstrapServers;
    @Bean
    public ProducerFactory<String, UserRes> producerFactoryJson() {
        Map<String,Object> configProps = new HashMap<>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,bootstrapServers);
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaProducerFactory<>(configProps);
    }
    @Bean
    public ProducerFactory<String,String> producerFactoryStr() {
        Map<String,Object> configProps = new HashMap<>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,bootstrapServers);
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class);
        return new DefaultKafkaProducerFactory<>(configProps);
    }
    @Bean
    public KafkaTemplate<String, UserRes> kafkaTemplateJson() {
        return new KafkaTemplate<>(producerFactoryJson());
    }
    @Bean
    public KafkaTemplate<String,String> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactoryStr());
    }

}
//      Khi muốn send message tới topic nào ta chỉ cần Autowire KafkaTemplate và gọi hàm send
//          Ví dụ : hàm gửi message tới topic test
//
//              @Autowired
//              private KafkaTemplate<String, String> kafkaTemplate;
//
//              public void sendMessage(String msg) {
//                  kafkaTemplate.send("test", msg);
//                                              }