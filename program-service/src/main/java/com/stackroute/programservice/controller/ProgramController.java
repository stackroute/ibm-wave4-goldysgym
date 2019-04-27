package com.stackroute.programservice.controller;

//import com.netflix.discovery.converters.Auto;

import com.stackroute.programservice.component.RabbitProducer;
import com.stackroute.programservice.domain.Program;
import com.stackroute.programservice.service.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class ProgramController {
    private ProgramService programService;
    private RabbitProducer rabbitProducer;

    @Autowired
    public ProgramController(ProgramService programServiceImpl, RabbitProducer rabbitProducer) {
        this.programService = programServiceImpl;
        this.rabbitProducer = rabbitProducer;
    }

    @PostMapping("/program")
    public ResponseEntity<Program> saveProgram(@RequestBody @Valid Program program) {
        Program programAdded = programService.saveProgram(program);
        rabbitProducer.produce(programService.getAllPrograms());
        return new ResponseEntity<>(programAdded, HttpStatus.CREATED);
    }

    @GetMapping("/programs")
    public ResponseEntity<List<Program>> getPrograms() {
        List<Program> allPrograms = programService.getAllPrograms();
        return new ResponseEntity<>(allPrograms, HttpStatus.OK);
    }

    @GetMapping("/programs/{programId}")
    public ResponseEntity<Program> getProgramsById(@PathVariable String programId) throws Exception {
        Program programById = programService.getProgramById(programId);
        if (programById == null)
            throw new Exception();
        return new ResponseEntity<>(programById, HttpStatus.OK);
    }




    @PutMapping("/programs")
    public ResponseEntity<Program> updateProgram(@RequestBody Program program) {
        Program updatedProgram = programService.updateProgram(program);
        return new ResponseEntity<>(updatedProgram, HttpStatus.OK);
    }

    @DeleteMapping("/programs/{programId}")
    public ResponseEntity<List<Program>> deleteProgramById(@PathVariable String programId) throws Exception {
        if (programService.getProgramById(programId) == null)
            throw new Exception();
        programService.deleteProgramById(programId);
        List<Program> allPrograms = programService.getAllPrograms();
        return new ResponseEntity<>(allPrograms, HttpStatus.OK);

    }

    @DeleteMapping("/programs/deleteAll")
    public ResponseEntity<String> deleteProgram() {
        programService.deleteProgram();
        return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);

    }
}
