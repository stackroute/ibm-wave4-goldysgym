package com.stackroute.enrollment.controller;

import com.stackroute.enrollment.domain.Enrollment;
import com.stackroute.enrollment.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class EnrollmentController
{

    private EnrollmentService enrollmentService;

    @Autowired
    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @PostMapping("/enrollment")
    public ResponseEntity<?> saveEnrollment(@RequestBody Enrollment enrollment) {
        ResponseEntity responseEntity;

        enrollmentService.saveEnrollment(enrollment);
        responseEntity = new ResponseEntity<String>("succefullly created", HttpStatus.CREATED);
        return responseEntity;
    }

    // this method will get all Enrollments
    @GetMapping("enrollments")
    public List<Enrollment> getALlEnrollments() {
        List<Enrollment> list = enrollmentService.getALLRest();
        return list;
    }

}
