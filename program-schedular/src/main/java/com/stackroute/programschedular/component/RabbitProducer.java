package com.stackroute.programschedular.component;

import com.stackroute.programschedular.config.RabbitConfig;
import com.stackroute.programschedular.domain.ProgramDto;
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


    public void produce(ProgramDto programDto) {
        logger.info("Inserting message to queue");
        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_NAME, RabbitConfig.ROUTING_KEY, programDto);
        logger.info("Message successfully sent");
        logger.info("Is listener returned ::: " + rabbitTemplate.isReturnListener());
    }
}
