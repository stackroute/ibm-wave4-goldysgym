package com.stackroute.programschedular.controller;

import com.stackroute.programschedular.domain.Year;
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

    @PostMapping("/program")
    public ResponseEntity<String> save(@RequestBody Year year) {
        programScheduleService.save(year);
        return new ResponseEntity<>("succefullly created", HttpStatus.CREATED);
    }

    @GetMapping("/programs")
    public ResponseEntity<List<Year>> get() {
        List<Year> list = programScheduleService.getALl();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}
