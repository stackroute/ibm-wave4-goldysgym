package com.stackroute.enrollment.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.enrollment.component.RabbitProducer;
import com.stackroute.enrollment.domain.Enrollment;
import com.stackroute.enrollment.domain.Subscription;
import com.stackroute.enrollment.service.EnrollmentService;
import com.stackroute.enrollment.service.EnrollmentServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest
public class EnrollmentControllerTest {

    @Autowired
    private MockMvc mockMvc;
    private Enrollment enrollment;
    @MockBean
    private RabbitProducer rabbitProducer;
    @MockBean
    private EnrollmentService enrollmentService;
    @InjectMocks
    private EnrollmentController enrollmentController;

    private List<Enrollment> list = null;

    @Before
    public void setUp() {

        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(enrollmentController).build();
        enrollment = new Enrollment();
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
        list = new ArrayList();
        list.add(enrollment);

    }

    @Test
    public void saveUser() throws Exception {
        when(enrollmentService.saveEnrollment(any())).thenReturn(enrollment);
        mockMvc.perform(MockMvcRequestBuilders.post("/enrollment")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(enrollment)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andDo(MockMvcResultHandlers.print());


    }


    @Test
    public void getAllUser() throws Exception {
        when(enrollmentService.getALLRest()).thenReturn(list);
        mockMvc.perform(MockMvcRequestBuilders.get("/enrollments")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(enrollment)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());

    }


    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
