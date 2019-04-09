package com.stackroute.programschedular.controller;

import com.stackroute.programschedular.domain.ProgramSchedule;
import com.stackroute.programschedular.service.ProgramScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ProgramScheduleController {

    private ProgramScheduleService programScheduleService;

    @Autowired
    public ProgramScheduleController(ProgramScheduleService programScheduleService) {
        this.programScheduleService = programScheduleService;
    }

    @RequestMapping("/program")
    public ResponseEntity<?> save(@RequestBody ProgramSchedule programSchedule)
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
    @PutMapping("/programput/{id}")
    public ResponseEntity<String> put(@RequestBody ProgramSchedule programSchedule,@PathVariable String id)
    {
        ProgramSchedule programSchedule1 = programScheduleService.put(programSchedule,id);
        return new ResponseEntity<String>("put successfull",HttpStatus.OK);
    }

}
