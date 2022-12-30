package com.example.mytoolkafka.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic topicNBQA () {
        return TopicBuilder.name("topic-nbqa")
                .partitions(5)
                .replicas(1)
                .build();
    }
    @Bean
    public NewTopic topicJsonNBQA() {
        return TopicBuilder.name("topic-nbqa-json")
                .partitions(5)
                .replicas(1)
                .build();
    }

//    @Bean
//    public NewTopic topic3() {
//        return TopicBuilder.name("thing3")
//                .assignReplicas(0, Arrays.asList(0, 1))
//                .assignReplicas(1, Arrays.asList(1, 2))
//                .assignReplicas(2, Arrays.asList(2, 0))
//                .config(TopicConfig.COMPRESSION_TYPE_CONFIG, "zstd")
//                .build();
//    }
}
