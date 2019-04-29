package com.stackroute.springbootneo4jCRUD.configuration;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//import java.util.Queue;

@Configuration
public class RabbitMqNeo4j {
    //The routing key,queue name,and exchange name has been taken as constants

    public static final String ROUTING_KEY = "goldy.gym.key.4";
    public static final String EXCHANGE_NAME = "goldy.gym.exchange";
    public static final String QUEUE_NAME = "goldy.gym.4";
    public static final String QUEUE_NAME1 = "goldy.gym.7";
    public static final String ROUTING_KEY1 = "goldy.gym.key.7";

    //Bean declaration of the queue
    @Bean
    Queue queue() {
        return new Queue(QUEUE_NAME, true);
    }

    //Bean declaration of the exchange(Topic exchange)
    @Bean
    TopicExchange topicExchange() {
        return new TopicExchange(EXCHANGE_NAME);
    }

    //Bean declaration for the binding between the queue and the exchange using the routing key
    @Bean
    Binding binding(Queue queue, TopicExchange topicExchange) {
        return BindingBuilder.bind(queue).to(topicExchange).with(ROUTING_KEY);
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    Queue queue1() {
        return new Queue(QUEUE_NAME1, true);
    }


    //Bean declaration for the binding between the queue and the exchange using the routing key
    @Bean
    Binding binding1(Queue queue1, TopicExchange topicExchange) {
        return BindingBuilder.bind(queue1).to(topicExchange).with(ROUTING_KEY1);
    }
}
