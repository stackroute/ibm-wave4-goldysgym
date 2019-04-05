package com.stackroute.programschedular.controller;

import com.stackroute.programschedular.domain.ProgramSchedule;
import com.stackroute.programschedular.service.ProgramScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProgramScheduleController {

    private ProgramScheduleService programScheduleService;

    @Autowired
    public ProgramScheduleController(ProgramScheduleService programScheduleService) {
        this.programScheduleService = programScheduleService;
    }

    @RequestMapping("/program")
    public ResponseEntity<?> save(ProgramSchedule programSchedule)
    {
        ProgramSchedule programSchedule1=programScheduleService.save(programSchedule);
        return new ResponseEntity<String>("succefullly created", HttpStatus.CREATED);
    }
    @RequestMapping("/programs")
    public ResponseEntity<List<ProgramSchedule>> get()
    {
        List<ProgramSchedule> list = programScheduleService.getALl();
        return new ResponseEntity<List<ProgramSchedule>>(list,HttpStatus.OK);
    }

}
