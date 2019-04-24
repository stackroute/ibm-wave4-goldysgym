package com.stackroute.enrollment.controller;

import com.stackroute.enrollment.component.RabbitProducer;
import com.stackroute.enrollment.domain.Enrollment;
import com.stackroute.enrollment.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
public class EnrollmentController {

    private EnrollmentService enrollmentService;
    private RabbitProducer rabbitProducer;

    @Autowired
    public EnrollmentController(EnrollmentService enrollmentService, RabbitProducer rabbitProducer) {
        this.enrollmentService = enrollmentService;
        this.rabbitProducer = rabbitProducer;
    }

    //it will add new enrollements
    @PostMapping("/enrollment")
    public ResponseEntity<String> saveEnrollment(@RequestBody Enrollment enrollment) throws Exception {
        Calendar cal=Calendar.getInstance();
        cal.setTime(enrollment.getDateOfBirth());
        int dobYear=cal.get(Calendar.YEAR);
        cal.setTime(new Date());
        int curYear= cal.get(Calendar.YEAR);
        enrollment.setAge(curYear-dobYear);
        Enrollment enrollment1 = enrollmentService.saveEnrollment(enrollment);
        if (enrollment1 == null) {
            throw new Exception();
        } else {
            rabbitProducer.produce(enrollment1);
            return new ResponseEntity<>("succefullly created", HttpStatus.CREATED);
        }
    }

    // this method will get all Enrollments
    @GetMapping("enrollments")
    public ResponseEntity<List<Enrollment>> getALlEnrollments() {
        List<Enrollment> list = enrollmentService.getALLRest();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    // this method will get Enrollment by id
    @GetMapping("enrollment/{id}")
    public ResponseEntity<Enrollment> getEnrollmentById(@PathVariable String id) throws Exception {
        Enrollment enrollment = enrollmentService.findbyId(id);
        if (enrollment == null) {
            throw new Exception();
        }
        return new ResponseEntity<>(enrollment, HttpStatus.OK);
    }

    // this is delete by id
    @DeleteMapping("enrollment/{id}")
    public ResponseEntity<String> deleteEnrollment(@PathVariable String id) throws Exception {
        if (id == null) {
            throw new Exception();
        }
        enrollmentService.delete(id);
        return new ResponseEntity<>("succefullly deleted", HttpStatus.OK);
    }

}
