package com.stackroute.programschedular.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitConfig
{
    public static final String QUEUE_NAME="goldy.gym.8";
    public static final String EXCHANGE_NAME="goldy.gym.exchange.1";
    public static final String ROUTING_KEY="goldy.gym.key.8";

    @Bean
    Queue queueOne()
    {
        return new Queue(QUEUE_NAME,true);
    }
    @Bean
    TopicExchange topicExchange(){
        return new TopicExchange(EXCHANGE_NAME);
    }
    @Bean
    Binding binding()
    {
        return BindingBuilder.bind(queueOne()).to(topicExchange()).with(ROUTING_KEY);
    }
    @Bean
    public MessageConverter jsonMessage()
    {
        return new Jackson2JsonMessageConverter();
    }
}
