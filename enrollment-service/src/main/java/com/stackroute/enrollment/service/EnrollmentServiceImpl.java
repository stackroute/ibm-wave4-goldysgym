package com.stackroute.enrollment.service;

import com.stackroute.enrollment.domain.Enrollment;
import com.stackroute.enrollment.domain.Subscription;
import com.stackroute.enrollment.repository.EnrollmentRepository;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {
    private EnrollmentRepository enrollmentRepository;


    public EnrollmentServiceImpl(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }


    public Enrollment saveEnrollment(Enrollment enrollment) {
        Calendar calendar = Calendar.getInstance();
        Subscription subscription = enrollment.getSubscription();
        int duration = subscription.getDuration();
        enrollment.setStartDate(calendar.getTime());
        calendar.add(Calendar.MONTH, duration);
        Date futureDate = calendar.getTime();
        enrollment.setEndDate(futureDate);

        return enrollmentRepository.save(enrollment);

    }

    public List<Enrollment> getALLRest() {
        return enrollmentRepository.findAll();
    }

    public Enrollment findbyId(String id) {
        return enrollmentRepository.findById(id).get();
    }

    public void delete(String id) {
        enrollmentRepository.deleteById(id);
    }

}
