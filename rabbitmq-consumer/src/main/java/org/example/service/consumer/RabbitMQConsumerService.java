package org.example.service.consumer;

import lombok.extern.slf4j.Slf4j;
import org.example.model.Notification;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RabbitMQConsumerService {

    @RabbitListener(queues = "${messaging.rabbitmq.messaging-queue}")
    public void consumeNotification(final Notification message) {
        log.info("Received message with default configuration: {}", message.toString());
    }
}
