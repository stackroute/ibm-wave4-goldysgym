package com.stackroute.enrollment.controller;

import com.stackroute.enrollment.domain.Enrollment;
import com.stackroute.enrollment.dto.EnrollmentDto;
import com.stackroute.enrollment.service.EnrollmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
public class EnrollmentController
{

    private EnrollmentService enrollmentService;
    private ModelMapper modelMapper;

    @Autowired
    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @PostMapping("/enrollment")
    public ResponseEntity<?> saveEnrollment(@RequestBody EnrollmentDto enrollmentDto) {
        Enrollment enrollment=converttoEntity(enrollmentDto);
        enrollmentService.saveEnrollment(enrollment);
        return new ResponseEntity<String>("succefullly created", HttpStatus.CREATED);
    }

    // this method will get all Enrollments
    @GetMapping("enrollments")
    public ResponseEntity<List<EnrollmentDto>> getALlEnrollments() {
        List<Enrollment> list = enrollmentService.getALLRest();
        List<EnrollmentDto> list1=list.stream().map(enrollment -> enrollmentToDto(enrollment))
                .collect(Collectors.toList());
        return new ResponseEntity<List<EnrollmentDto>>(list1,HttpStatus.OK);
    }
    // this method will get Enrollment by id
    @GetMapping("enrollment/{id}")
    public ResponseEntity<?> getEnrollmentById(@PathVariable String id) {
        Enrollment enrollment= enrollmentService.findbyId(id);
        EnrollmentDto enrollmentDto=enrollmentToDto(enrollment);
        return new ResponseEntity<Enrollment>(enrollment,HttpStatus.OK);
    }

    public EnrollmentDto enrollmentToDto(Enrollment enrollment)
    {
        EnrollmentDto enrollmentDto=modelMapper.map(enrollment, EnrollmentDto.class);
        return  enrollmentDto;
    }
    public  Enrollment converttoEntity(EnrollmentDto enrollmentDto)
    {
        Enrollment enrollment=modelMapper.map(enrollmentDto,Enrollment.class);
        return  enrollment;
    }
}
