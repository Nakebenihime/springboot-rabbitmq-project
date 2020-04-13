package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitMQSubscriberApplication {
    public static void main(String[] args) {
        SpringApplication.run(RabbitMQSubscriberApplication.class, args);
    }
}
