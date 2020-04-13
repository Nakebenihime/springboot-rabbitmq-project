package org.example.controller.subscriber;

import lombok.extern.slf4j.Slf4j;
import org.example.service.subscriber.RabbitMQSubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/notifications")
public class SubscriberController {

    private RabbitMQSubscriberService rabbitMQSubscriberService;

    @Autowired
    public void setRabbitMQSubscriberService(RabbitMQSubscriberService rabbitMQSubscriberService) {
        this.rabbitMQSubscriberService = rabbitMQSubscriberService;
    }

    @GetMapping("/send")
    public void subscriber() {
        log.info("Event redirection was received, creating a notification...");
        rabbitMQSubscriberService.sendMessage();
    }
}
