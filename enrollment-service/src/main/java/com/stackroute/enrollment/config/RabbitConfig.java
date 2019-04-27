package com.stackroute.enrollment.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitConfig {
    public static final String QUEUE_NAME = "goldy.gym";
    public static final String EXCHANGE_NAME = "goldy.gym.exchange";
    public static final String ROUTING_KEY = "goldy.gym.key";
    public static final String QUEUE_NAME_1 = "goldy.gym.4";
    public static final String ROUTING_KEY_1 = "goldy.gym.key.4";

    @Bean
    Queue queueOne() {
        return new Queue(QUEUE_NAME, true);
    }

    @Bean
    Queue queueTwo() {
        return new Queue(QUEUE_NAME_1, true);
    }

    @Bean
    TopicExchange topicExchange() {
        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    Binding bindingOne() {
        return BindingBuilder.bind(queueOne()).to(topicExchange()).with(ROUTING_KEY);
    }

    @Bean
    Binding bindingTwo() {
        return BindingBuilder.bind(queueTwo()).to(topicExchange()).with(ROUTING_KEY_1);
    }

    @Bean
    public MessageConverter jsonMessage() {
        return new Jackson2JsonMessageConverter();
    }
}
