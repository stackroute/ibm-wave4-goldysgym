package com.stackroute.springbootneo4jCRUD.consumer;

import com.stackroute.springbootneo4jCRUD.configuration.RabbitMqNeo4j;
import com.stackroute.springbootneo4jCRUD.domain.Program;
import com.stackroute.springbootneo4jCRUD.domain.Session;
import com.stackroute.springbootneo4jCRUD.domain.User;
import com.stackroute.springbootneo4jCRUD.domain.UserDetails;
import com.stackroute.springbootneo4jCRUD.service.UserService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class UserConsumer {

     private User user;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserService userService;
    @RabbitListener(queues = RabbitMqNeo4j.QUEUE_NAME)
    public void consume(UserDetails userDetails){
        userService.saveUser(userDetails);
        logger.info("Consumer 1");
        logger.info("Message Received: " + userDetails.toString());
    }



}
