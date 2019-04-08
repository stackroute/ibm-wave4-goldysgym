package com.stackroute.enrollment.service;

import com.stackroute.enrollment.domain.Enrollment;
import com.stackroute.enrollment.repository.EnrollmentRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.client.ExpectedCount.times;

public class EnrollmentServiceTest {
    private Enrollment enrollment;

    //Create a mock for UserRepository
    @Mock
    private EnrollmentRepository enrollmentRepository;

    //Inject the mocks as dependencies into UserServiceImpl
    @InjectMocks
    private EnrollmentService enrollmentService;
    List<Enrollment> list= null;


    @Before
    public void setUp(){
        //Initialising the mock object
        MockitoAnnotations.initMocks(this);
        enrollment = new Enrollment();
        enrollment.setLastName("John");
        enrollment.setUserId("101");
        enrollment.setFirstName("Jenny");
        list = new ArrayList<>();
        list.add(enrollment);


    }

    @Test
    public void saveUserTestSuccess()  {

        when(enrollmentRepository.save((Enrollment)any())).thenReturn(enrollment);
        Enrollment enrollment1 = enrollmentService.saveEnrollment(enrollment);
        Assert.assertEquals(enrollment,enrollment1);

        //verify here verifies that userRepository save method is only called once
       // verify(enrollmentRepository,times(1)).save(enrollment);

    }


    @Test
    public void getAllUser(){

        enrollmentRepository.save(enrollment);
        //stubbing the mock to return specific data
        when(enrollmentRepository.findAll()).thenReturn(list);
        List<Enrollment> userlist = enrollmentService.getALLRest();
        Assert.assertEquals(list,userlist);
    }


}