package com.stackroute.enrollment.component;

import com.stackroute.enrollment.config.RabbitConfig;
import com.stackroute.enrollment.domain.Enrollment;
import com.stackroute.enrollment.domain.User;
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


    public void produce(Enrollment enrollment) {
        logger.info("Inserting message to queue");
        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_NAME, RabbitConfig.ROUTING_KEY, user);
        logger.info("Message successfully sent");
        logger.info("Is listener returned ::: " + rabbitTemplate.isReturnListener());
    }
}
