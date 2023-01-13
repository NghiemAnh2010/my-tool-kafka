package com.example.mytoolkafka.configuration;

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
        // Config này cho phép producer sẽ đảm bảo rằng chính xác mỗi bản sao của mỗi message được ghi lại trong stream
        configProps.put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG,true);
        // Config này có nghĩa là Leader sẽ đợi toàn bộ các bản sao ko đồng bộ xác nhận message . Điều này sẽ đảm bảo rằng các message sẽ ko bị mất đi miễn là còn ít nhất 1 bản sao ko đồng bộ
        configProps.put(ProducerConfig.ACKS_CONFIG,"all");
        configProps.put(ProducerConfig.MAX_IN_FLIGHT_REQUESTS_PER_CONNECTION,5);
        // Đặt giá tri này > 0 sẽ khiến Consumer gửi lại bất kỳ message nào mà việc gửi ko thành công do lỗi tạm thời có thể xảy ra
        configProps.put(ProducerConfig.RETRIES_CONFIG,2147483647);
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