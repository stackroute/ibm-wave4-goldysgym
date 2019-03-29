package com.stackroute.enrollment.service;

import com.stackroute.enrollment.domain.Enrollment;
import com.stackroute.enrollment.repository.EnrollmentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EnrollmentService
{
private EnrollmentRepository enrollmentRepository;


    public EnrollmentService(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }


    public Enrollment saveEnrollment(Enrollment enrollment)
    {
        int duration= enrollment.getDuration();
        LocalDate futureDate =LocalDate.now().plusMonths(duration);
        enrollment.setEndDate(futureDate);
        enrollment.setStartDate(LocalDate.now());
        Enrollment enrollment1=enrollmentRepository.save(enrollment);
        return  enrollment1;
    }
    public List<Enrollment> getALLRest(){
        return (List<Enrollment>)enrollmentRepository.findAll();
    }
    public Enrollment findbyId(String id) {
        return enrollmentRepository.findById(id).get();
    }
}
