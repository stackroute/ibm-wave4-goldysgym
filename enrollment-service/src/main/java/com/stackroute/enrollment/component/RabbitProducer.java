package com.stackroute.enrollment.component;

import com.stackroute.enrollment.config.RabbitConfig;
import com.stackroute.enrollment.domain.Enrollment;
import com.stackroute.enrollment.domain.UserDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;

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
        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_NAME, RabbitConfig.ROUTING_KEY, enrollment);
        logger.info("Message successfully sent");
        logger.info("Message successfully sent");
        logger.info("Is listener returned ::: " + rabbitTemplate.isReturnListener());
        Calendar cal = Calendar.getInstance();
        cal.setTime(enrollment.getDateOfBirth());
        int year = cal.get(Calendar.YEAR);
        cal.setTime(new Date());
        int currentYear=cal.get(Calendar.YEAR);
        int age = currentYear-year;
        UserDetails userDetails= new UserDetails();
        userDetails.setName(enrollment.getFirstName());
        userDetails.setAge(age);
        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_NAME,RabbitConfig.ROUTING_KEY,userDetails);
    }
}
