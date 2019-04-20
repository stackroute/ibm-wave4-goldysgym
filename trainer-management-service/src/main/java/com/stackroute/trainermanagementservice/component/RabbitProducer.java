package com.stackroute.trainermanagementservice.component;

import com.stackroute.trainermanagementservice.configuration.RabbitConfig;
import com.stackroute.trainermanagementservice.domain.Program;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class RabbitProducer {
    Logger log = LoggerFactory.getLogger(this.getClass());
    private RabbitTemplate rabbitTemplate;

    @Autowired
    public RabbitProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void produce(Program program) {
        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_NAME_2, RabbitConfig.ROUTING_KEY_2, program);
        log.info("message sent");
    }
}
