package com.stackroute.trainermanagementservice.component;

import com.stackroute.trainermanagementservice.configuration.RabbitConfig;
import com.stackroute.trainermanagementservice.domain.ProgramDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitmqConsumer {


    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private TrainerAllocation trainerAllocation;


    /**
     * This method annotated with RabbitListener listens to the queue and takes up tha message in the queue
     *
     * @param programDto
     */
    @RabbitListener(queues = RabbitConfig.QUEUE_NAME_3)
    public void consume(ProgramDto programDto) {
        logger.info("Consumer 1");
        logger.info("Message Received: " + programDto.toString());
        trainerAllocation.allocation(programDto);

    }
}


