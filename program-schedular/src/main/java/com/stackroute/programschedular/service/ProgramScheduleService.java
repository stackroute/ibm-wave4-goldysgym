package com.stackroute.programschedular.service;

import com.stackroute.programschedular.domain.ProgramSchedule;
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

    public ProgramSchedule save(ProgramSchedule programSchedule)
    {
        ProgramSchedule programSchedule1=programScheduleRepository.save(programSchedule);
        return programSchedule1;
    }
    public List<ProgramSchedule> getALl()
    {
        return  (List<ProgramSchedule>)programScheduleRepository.findAll();
    }
    public  ProgramSchedule put(ProgramSchedule programSchedule, String id)
    {
        programSchedule.setUserId(id);
        return programScheduleRepository.save(programSchedule);
    }
}
