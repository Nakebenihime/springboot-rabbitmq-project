package org.example.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration implements RabbitListenerConfigurer {

    @Value("${messaging.rabbitmq.messaging-queue}")
    public String QUEUE_NAME;
    @Value("${messaging.rabbitmq.messaging-exchange}")
    public String EXCHANGE_NAME;
    @Value("${messaging.rabbitmq.messaging-routingkey}")
    public String ROUTING_KEY;

    @Bean
    public TopicExchange TopicExchange() {
        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    public Queue QueueGeneric() {
        return new Queue(QUEUE_NAME, true, false, false, null);
    }

    @Bean
    public Binding BindingGeneric() {
        return BindingBuilder.bind(QueueGeneric()).to(TopicExchange()).with(ROUTING_KEY);
    }

    @Bean
    public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
        final var rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(producerJackson2MessageConverter());
        return rabbitTemplate;
    }

    @Bean
    public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Override
    public void configureRabbitListeners(RabbitListenerEndpointRegistrar rabbitListenerEndpointRegistrar) {
    }
}
