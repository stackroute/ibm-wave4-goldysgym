package com.stackroute.userauthentication.service;

import com.stackroute.userauthentication.domain.User;
import com.stackroute.userauthentication.repo.UserRepository;
import com.stackroute.userauthentication.service.UserServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
@ContextConfiguration(locations = {"classpath*:/spring/test-context.xml"})
public class UserServiceTest {

    private User user;

    //Create a mock for UserRepository
    @Mock
    private UserRepository userRepository;

    //Inject the mocks as dependencies into UserServiceImpl
    @InjectMocks
    private UserServiceImpl userServiceImpl;


    @Before
    public void setUp() {
        //Initialising the mock object
        MockitoAnnotations.initMocks(this);
        user = new User();
        user.setId("1");
        user.setFirstName("Sam");
        user.setLastName("Ketty");
        user.setEmail("samketty@gmail.com");
        user.setPassword("12345");
        user.setCnfpassword("12345");
        user.setActive(true);
        user.setRole("USER");


    }

    @Test
    public void saveUserTestSuccess() {

        when(userRepository.save((User) any())).thenReturn(user);
        User savedUser = userServiceImpl.save(user);
        Assert.assertEquals(user, savedUser);

        //verify here verifies that userRepository save method is only called once
        verify(userRepository, times(1)).save(user);

    }

    @Test
    public void saveUserTestFailure() {
        when(userRepository.save((User) any())).thenReturn(null);
        User savedUser = userServiceImpl.save(user);
        // System.out.println("savedUser" + savedUser);
        Assert.assertNotEquals(user, savedUser);

       /*doThrow(new UserAlreadyExistException()).when(userRepository).findById(eq(101));
       userService.saveUser(user);*/


    }


}
