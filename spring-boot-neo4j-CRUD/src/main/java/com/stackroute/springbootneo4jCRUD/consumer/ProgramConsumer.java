package com.stackroute.springbootneo4jCRUD.consumer;

import com.stackroute.springbootneo4jCRUD.configuration.RabbitMqNeo4j;
import com.stackroute.springbootneo4jCRUD.domain.Program;
import com.stackroute.springbootneo4jCRUD.domain.Session;
import com.stackroute.springbootneo4jCRUD.domain.User;
import com.stackroute.springbootneo4jCRUD.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProgramConsumer {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserService userService;
    @RabbitListener(queues = RabbitMqNeo4j.QUEUE_NAME1)
    public void consume1(Program program){
        Session session= new Session();
        session.setId(1L);
        session.setName(program.getProgramName());
        userService.saveSession(session);
        logger.info("Consumer 1");
        logger.info("Message Received: " + program.toString());
    }
}
