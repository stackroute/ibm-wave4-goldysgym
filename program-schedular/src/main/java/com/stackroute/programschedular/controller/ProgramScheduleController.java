package com.stackroute.programschedular.controller;

import com.stackroute.programschedular.component.RabbitProducer;
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
    private RabbitProducer rabbitProducer;

    @Autowired
    public ProgramScheduleController(ProgramScheduleService programScheduleService,RabbitProducer rabbitProducer) {
        this.programScheduleService = programScheduleService;
        this.rabbitProducer = rabbitProducer;

    }

    @PutMapping("/program")
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
                List<Slots> slots = day[i].getSlots();
                for (int j = 0; j < slots.size(); j++) {
                    if (slots.get(j).getTime().equals(time)) {
                        System.out.println("SLOTSSSSS******" + slots.get(j).getUsers());
                        users = slots.get(j).getUsers();
                        users.add(name);
                        slots.get(j).setUsers(users);
//                        programScheduleService.save(year);
//                        System.out.println("success");
                       break;
                    }
                }
            }
        }
        Year year1 = programScheduleService.save(year);
        return new ResponseEntity<String>("succefullly created", HttpStatus.OK);
    }
    @PutMapping("/adminupdate")
    public ResponseEntity<?> adminsave(@RequestParam String time, @RequestParam String date, @RequestParam String program,@RequestParam int capacity, @RequestBody Year year) throws Exception {
        List<String> users = null;
        year.setYear("2019");
        Month[] month = year.getMonth();
        Day[] day = month[0].getDays();
        for (int i = 0; i < day.length; i++) {
            if (day[i].getDate().equals(date)) {
                Slots slots= new Slots();
                slots.setTime(time);
                slots.setCapacity(capacity);
                slots.setProgramName(program);
                List<Slots> slots1=day[i].getSlots();
                slots1.add(slots);
                 day[i].setSlots(slots1);
                }
            }

        Year year1 = programScheduleService.save(year);
        ProgramDto programDto= new ProgramDto(date,time,program);
        rabbitProducer.produce(programDto);
        return new ResponseEntity<String>("succefullly created", HttpStatus.OK);
    }

    @GetMapping("/programs")
    public ResponseEntity<List<Year>> get() {
        List<Year> list = programScheduleService.getALl();
        return new ResponseEntity<List<Year>>(list, HttpStatus.OK);
    }

}
