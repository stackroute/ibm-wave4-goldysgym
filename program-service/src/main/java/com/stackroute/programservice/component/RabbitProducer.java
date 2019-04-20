package com.stackroute.programservice.component;

import com.stackroute.programservice.configuration.RabbitConfig;
import com.stackroute.programservice.domain.Program;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitProducer {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private RabbitTemplate rabbitTemplate;

    @Autowired
    public RabbitProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }


    public void produce(Program program) {
        logger.info("Inserting message to queue");
        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_NAME_1, RabbitConfig.ROUTING_KEY_1, program);
        logger.info("Message successfully sent");

    }
}
