package com.stackroute.enrollment.controller;

import com.stackroute.enrollment.component.RabbitProducer;
import com.stackroute.enrollment.domain.Enrollment;
import com.stackroute.enrollment.service.EnrollmentService;
import com.stackroute.enrollment.service.EnrollmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<?> saveEnrollment(@RequestBody Enrollment enrollment) throws Exception {
        Enrollment enrollment1 = enrollmentService.saveEnrollment(enrollment);
        if (enrollment1==null) {
            throw new Exception();
        } else {
            rabbitProducer.produce(enrollment1);
            return new ResponseEntity<String>("succefullly created", HttpStatus.CREATED);
        }
    }

    // this method will get all Enrollments
    @GetMapping("enrollments")
    public ResponseEntity<List<Enrollment>> getALlEnrollments() {
        List<Enrollment> list = enrollmentService.getALLRest();
        return new ResponseEntity<List<Enrollment>>(list, HttpStatus.OK);
    }

    // this method will get Enrollment by id
    @GetMapping("enrollment/{id}")
    public ResponseEntity<?> getEnrollmentById(@PathVariable String id) throws Exception {
        Enrollment enrollment = enrollmentService.findbyId(id);
        if (enrollment == null) {
            throw new Exception();
        }
        return new ResponseEntity<Enrollment>(enrollment, HttpStatus.OK);
    }

    // this is delete by id
    @DeleteMapping("enrollment/{id}")
    public ResponseEntity<?> deleteEnrollment(@PathVariable String id) throws Exception {
        if (id == null) {
            throw new Exception();
        }
        enrollmentService.delete(id);
        return new ResponseEntity<String>("succefullly deleted", HttpStatus.OK);
    }

}
