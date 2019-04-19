package com.stackroute.programschedular.controller;

import com.stackroute.programschedular.domain.*;
import com.stackroute.programschedular.service.ProgramScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
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
    public ResponseEntity<?> save(@RequestBody Year year) {
        Year year1 = programScheduleService.save(year);
        return new ResponseEntity<String>("succefullly created", HttpStatus.CREATED);
    }

    @PutMapping("/user")
    public ResponseEntity<?> save(@RequestParam String time, @RequestParam String date, @RequestParam String name, @RequestBody Year year) throws Exception {
        System.out.println(name + " " + date + " " + " " + time + " " + year);
        List<String> users = null;
        year.setYear("2019");
        Month[] month = year.getMonth();
        Day[] day = month[0].getDays();
        for (int i = 0; i < day.length; i++) {
            if (day[i].getDate().equals(date)) {
                Slots[] slots = day[i].getSlots();
                for (int j = 0; j < slots.length; j++) {
                    if (slots[j].getTime().equals(time)) {
                        System.out.println("SLOTSSSSS******" + slots[j].getUsers());
                        users = slots[j].getUsers();
                        users.add(name);
                        slots[j].setUsers(users);

                      break;
                    }
                }
            }
        }
        Year year1 = programScheduleService.save(year);
        return new ResponseEntity<String>("succefullly created", HttpStatus.CREATED);
    }

    @PutMapping("/adminupdate")
    public ResponseEntity<?> adminsave(@RequestParam String time, @RequestParam String date, @RequestParam String program,@RequestParam int capacity, @RequestBody Year year) throws Exception {
        List<String> users = null;
        year.setYear("2019");
        Month[] month = year.getMonth();
        Day[] day = month[0].getDays();
        for (int i = 0; i < day.length; i++) {
            if (day[i].getDate().equals(date)) {
                Slots[] slots = day[i].getSlots();
                for (int j = 0; j < slots.length; j++) {
                    if (slots[j].getTime().equals(time)) {
                        System.out.println("SLOTSSSSS******" + slots[j].getUsers());
                        slots[j].setTime(time);
                        slots[j].setProgramName(program);
                        slots[j].setCapacity(capacity);
                    }
                }
            }
        }
        Year year1 = programScheduleService.save(year);
        return new ResponseEntity<String>("succefullly created", HttpStatus.OK);
    }


    @GetMapping("/programs")
    public ResponseEntity<List<Year>> get() {
        List<Year> list = programScheduleService.getALl();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}
