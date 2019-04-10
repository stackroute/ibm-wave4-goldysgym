package com.stackroute.programschedular.service;

import com.stackroute.programschedular.domain.Year;
import com.stackroute.programschedular.repository.ProgramScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgramScheduleService
{

    ProgramScheduleRepository programScheduleRepository;
    public ProgramScheduleService(ProgramScheduleRepository programScheduleRepository) {
        this.programScheduleRepository = programScheduleRepository;
    }

    public Year save(Year year)
    {
        Year year11=programScheduleRepository.save(year);
        return year11;
    }
    public List<Year> getALl()
    {
        return  (List<Year>)programScheduleRepository.findAll();
    }

}
