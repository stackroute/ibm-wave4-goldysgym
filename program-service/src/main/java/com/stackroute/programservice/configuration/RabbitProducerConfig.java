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
public class RabbitProducerConfig {

    //All the routing key,queue name and exchange
    public static final String QUEUE_NAME = "goldy.gym.2";
    public static final String EXCHANGE_NAME = "goldy.gym.exchange";
    public static final String ROUTING_KEY = "goldy.gym.key.2";

    //Bean declaration for queue1
    @Bean
    Queue queueOne() {
        return new Queue(QUEUE_NAME, true);
    }

    //Bean declaration for TopicExchange
    @Bean
    TopicExchange topicExchange() {
        return new TopicExchange(EXCHANGE_NAME);
    }

    //Bean declaration for binding the exchange with queue1
    @Bean
    Binding bindingOne() {
        return BindingBuilder.bind(queueOne()).to(topicExchange()).with(ROUTING_KEY);
    }

    //Bean declaration for binding the exchange with queue1

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

}
