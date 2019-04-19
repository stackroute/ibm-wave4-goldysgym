package com.stackroute.enrollment.service;

import com.stackroute.enrollment.domain.Enrollment;
import com.stackroute.enrollment.domain.Subscription;
import com.stackroute.enrollment.repository.EnrollmentRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class EnrollmentServiceImplTest {
    private Enrollment enrollment;

    //Create a mock for UserRepository
    @Mock
    private EnrollmentRepository enrollmentRepository;

    //Inject the mocks as dependencies into UserServiceImpl
    @InjectMocks
    private EnrollmentServiceImpl enrollmentServiceImpl;
    List<Enrollment> list= null;


    @Before
    public void setUp(){
        //Initialising the mock object
        MockitoAnnotations.initMocks(this);
        enrollment = new Enrollment();
        enrollment.setUserId("1");
        enrollment.setFirstName("Jhon");
        enrollment.setLastName("Doe");
        enrollment.setEmail("Jhon@gmail.com");
        enrollment.setPassword("12345");
        enrollment.setDateOfBirth(new Date(1993 - 03 - 26));
        enrollment.setGender("Male");
        enrollment.setHeight(180.00);
        enrollment.setWeight(62.00);
        enrollment.setSubscription(new Subscription("1", "Gold", "Desc", "xyz", 6, 4200.00));
        list = new ArrayList<>();
        list.add(enrollment);


    }

    @Test
    public void saveUserTestSuccess()  {

        when(enrollmentRepository.save((Enrollment)any())).thenReturn(enrollment);
        Enrollment enrollment1 = enrollmentServiceImpl.saveEnrollment(enrollment);
        Assert.assertEquals(enrollment,enrollment1);

        //verify here verifies that userRepository save method is only called once
        verify(enrollmentRepository,times(1)).save(enrollment);

    }


    @Test
    public void getAllUser(){

        enrollmentRepository.save(enrollment);
        //stubbing the mock to return specific data
        when(enrollmentRepository.findAll()).thenReturn(list);
        List<Enrollment> userlist = enrollmentServiceImpl.getALLRest();
        Assert.assertEquals(list,userlist);
    }


}