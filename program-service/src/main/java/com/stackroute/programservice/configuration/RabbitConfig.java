package com.stackroute.programservice.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*This class contains thre declaration of the beans */
@Configuration
public class RabbitConfig {

    //All the routing key,queue name and exchange
    public static final String QUEUE_NAME_1 = "goldy.gym.1";
    public static final String EXCHANGE_NAME_1 = "goldy.gym.exchange.1";
    public static final String ROUTING_KEY_1 = "goldy.gym.key.1";
    public static final String QUEUE_NAME_2 = "goldy.gym.2";
    public static final String ROUTING_KEY_2 = "goldy.gym.key.2";
    public static final String EXCHANGE_NAME_2 = "goldy.gym.exchange.2";

    //Bean declaration for queue1
    @Bean
    Queue queueOne() {
        return new Queue(QUEUE_NAME_1, true);
    }

    //Bean declaration for queue1
    @Bean
    Queue queueTwo() {
        return new Queue(QUEUE_NAME_2, true);
    }

    //Bean declaration for TopicExchange
    @Bean
    TopicExchange topicExchangeOne() {
        return new TopicExchange(EXCHANGE_NAME_1);
    }

    //Bean declaration for TopicExchange
    @Bean
    TopicExchange topicExchangeTwo() {
        return new TopicExchange(EXCHANGE_NAME_2);
    }

    //Bean declaration for binding the exchange with queue1
    @Bean
    Binding bindingOne() {
        return BindingBuilder.bind(queueOne()).to(topicExchangeOne()).with(ROUTING_KEY_1);
    }

    //Bean declaration for binding the exchange with queue1
    @Bean
    Binding bindingTwo() {
        return BindingBuilder.bind(queueTwo()).to(topicExchangeTwo()).with(ROUTING_KEY_2);
    }


    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

}
