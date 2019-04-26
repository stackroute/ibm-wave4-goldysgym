package com.stackroute.trainermanagementservice.configuration;

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


    //The routing key,queue name,and exchange name has been taken as constants
    public static final String ROUTING_KEY_1 = "goldy.gym.key.1";
    public static final String EXCHANGE_NAME_1 = "goldy.gym.exchange.1";
    public static final String QUEUE_NAME_1 = "goldy.gym.1";
    public static final String QUEUE_NAME_2 = "goldy.gym.2";
    public static final String ROUTING_KEY_2 = "goldy.gym.key.2";
    public static final String EXCHANGE_NAME_2 = "goldy.gym.exchange.2";
    public static final String QUEUE_NAME_3 = "goldy.gym.8";
    public static final String ROUTING_KEY_3 = "goldy.gym.key.8";

    //Bean declaration of the queue
    @Bean
    Queue queue() {
        return new Queue(QUEUE_NAME_1, true);
    }

    //Bean declaration of the queue
    @Bean
    Queue queueOne() {
        return new Queue(QUEUE_NAME_2, true);
    }


    //Bean declaration of the queue
    @Bean
    Queue queueTwo() {
        return new Queue(QUEUE_NAME_3, true);
    }

    //Bean declaration of the exchange(Topic exchange)
    @Bean
    TopicExchange topicExchangeOne() {
        return new TopicExchange(EXCHANGE_NAME_1);
    }

    //Bean declaration of the exchange(Topic exchange)
    @Bean
    TopicExchange topicExchangeTwo() {
        return new TopicExchange(EXCHANGE_NAME_2);
    }

    //Bean declaration for the binding between the queue and the exchange using the routing key
    @Bean
    Binding binding(Queue queue, TopicExchange topicExchangeOne) {
        return BindingBuilder.bind(queue).to(topicExchangeOne).with(ROUTING_KEY_1);
    }

    //Bean declaration for the binding between the queue and the exchange using the routing key
    @Bean
    Binding bindingOne(Queue queueOne, TopicExchange topicExchangeTwo) {
        return BindingBuilder.bind(queueOne).to(topicExchangeTwo).with(ROUTING_KEY_2);
    }

    //Bean declaration for the binding between the queue and the exchange using the routing key
    @Bean
    Binding bindingTwo(Queue queueTwo, TopicExchange topicExchangeTwo) {
        return BindingBuilder.bind(queueTwo).to(topicExchangeTwo).with(ROUTING_KEY_3);
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

}

