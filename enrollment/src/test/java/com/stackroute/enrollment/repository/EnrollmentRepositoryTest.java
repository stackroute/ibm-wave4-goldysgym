package com.stackroute.enrollment.repository;

import com.stackroute.enrollment.domain.Enrollment;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@DataMongoTest
public class EnrollmentRepositoryTest {

        @Autowired
        private EnrollmentRepository enrollmentRepository;
        private Enrollment enrollment;

        @Before
        public void setUp()
        {
            enrollment = new Enrollment();
            enrollment.setAge(10);
            enrollment.setFirstName("John");
            enrollment.setUserId("101");
            enrollment.setLastName("Jenny");

        }

        @After
        public void tearDown(){

            enrollmentRepository.deleteAll();
        }


        @Test
        public void testSaveUser(){
            enrollmentRepository.save(enrollment);
            Enrollment fetchUser = enrollmentRepository.findById(enrollment.getUserId()).get();
            Assert.assertEquals("101",fetchUser.getUserId());

        }

        @Test
        public void testSaveUserFailure(){
            Enrollment testUser = new Enrollment();
            testUser.setFirstName("Harry");
            testUser.setLastName("john");
            testUser.setUserId("201");
            testUser.setAge(34);
            enrollmentRepository.save(enrollment);
            Enrollment fetchUser = enrollmentRepository.findById(enrollment.getUserId()).get();
            Assert.assertNotSame(testUser, enrollment);
        }

        @Test
        public void testGetAllUser(){
            Enrollment u = new Enrollment();
            u.setFirstName("johny");
            u.setLastName("jenny");
            u.setUserId("102");
            u.setAge(10);
            Enrollment u1 = new Enrollment();
            u.setFirstName("Harry");
            u.setLastName("jenny");
            u.setUserId("103");
            u.setAge(11);
            enrollmentRepository.save(u);
            enrollmentRepository.save(u1);

            List<Enrollment> list = enrollmentRepository.findAll();
            Assert.assertEquals("Johny",list.get(0).getFirstName());



        }




}