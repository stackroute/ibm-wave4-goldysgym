package com.stackroute.userauthentication.component;

import com.stackroute.userauthentication.config.RabbitConfig;
import com.stackroute.userauthentication.domain.Enrollment;
import com.stackroute.userauthentication.domain.User;
import com.stackroute.userauthentication.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    private UserService userService;

    @Autowired
    public Consumer(UserService userService) {
        this.userService = userService;
    }

    private User user = new User();

    @RabbitListener(queues = RabbitConfig.QUEUE_NAME)
    public void consume(Enrollment enrollment) {
        logger.info("Message has: ", enrollment.getFirstName());
        user.setId(enrollment.getUserId());
        user.setFirstName(enrollment.getFirstName());
        user.setLastName(enrollment.getLastName());
        user.setEmail(enrollment.getEmail());
        user.setPassword(enrollment.getPassword());
        user.setCnfpassword(enrollment.getPassword());
        user.setActive(true);
        user.setRole("USER");
        userService.save(user);
    }
}
