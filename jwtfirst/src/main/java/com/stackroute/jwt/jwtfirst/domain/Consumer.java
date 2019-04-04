package com.stackroute.jwt.jwtfirst.domain;

import com.stackroute.jwt.jwtfirst.RabbitConfig;
import com.stackroute.jwt.jwtfirst.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public UserService userService;

    public User user=new User();

    @RabbitListener(queues = RabbitConfig.QUEUE_NAME)
    public void consume(Enrollment enrollment) {
        logger.info("Message has: " + enrollment.getFirstName());
        user.setId(enrollment.getUserId());
        user.setFirstName(enrollment.getFirstName());
        user.setLastName(enrollment.getLastName());
        user.setEmail(enrollment.getEmail());
        user.setPassword(enrollment.getPassword());
        user.setCnfpassword(enrollment.getPassword());
        user.setActive(true);
        user.setRole("USER");
       // user.setRegdate(enrollment.getStartDate());
        userService.save(user);
    }
}