package com.example.mytoolkafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;;

@SpringBootApplication
public class MyToolKafkaApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyToolKafkaApplication.class, args);
    }
}
