package com.stackroute.programservice.component;

import com.stackroute.programservice.configuration.RabbitConfig;
import com.stackroute.programservice.domain.Program;
import com.stackroute.programservice.service.ProgramService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitmqConsumer {


    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ProgramService programService;


    /**
     * This method annotated with RabbitListener listens to the queue and takes up tha message in the queue
     *
     * @param program
     */
    @RabbitListener(queues = RabbitConfig.QUEUE_NAME_2)
    public void consume(Program program) {
        logger.info("Program Consumed");
        logger.info("Message Received: " + program.toString());
        programService.updateProgram(program);

    }
}


