package org.example.service.subscriber;

import lombok.extern.slf4j.Slf4j;
import org.example.configuration.RabbitMQConfiguration;
import org.example.model.Notification;
import org.example.repository.NotificationRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Slf4j
@Service
public class RabbitMQSubscriberService {

    private NotificationRepository notificationRepository;

    @Autowired
    public void setNotificationRepository(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    private RabbitMQConfiguration rabbitMQConfiguration;

    @Autowired
    public void setRabbitMQConfiguration(RabbitMQConfiguration rabbitMQConfiguration) {
        this.rabbitMQConfiguration = rabbitMQConfiguration;
    }

    private RabbitTemplate rabbitTemplate;

    @Autowired
    public void setRabbitTemplate(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }


    public RabbitMQSubscriberService(final RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage() {
        Notification message = new Notification("New notification", new Random().nextInt(50), false);
        notificationRepository.save(message);
        log.info("Notification has been saved {}", message.toString());
        rabbitTemplate.convertAndSend(rabbitMQConfiguration.EXCHANGE_NAME, rabbitMQConfiguration.ROUTING_KEY, message);
        log.info("Notification has been sent to rabbitMQ {}", message.toString());
    }
}
