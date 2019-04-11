package com.stackroute.programservice.controller;

import com.stackroute.programservice.domain.Program;
import com.stackroute.programservice.service.ProgramService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class   ProgramController {
    private ProgramService programService;

    public ProgramController(ProgramService programServiceImpl) {
        this.programService = programServiceImpl;
    }

    @PostMapping("/program")
    public ResponseEntity<Program> saveProgram(@RequestBody @Valid Program program) {
        Program programAdded = programService.saveProgram(program);
        return new ResponseEntity<Program>(programAdded, HttpStatus.CREATED);
    }

    @GetMapping("/programs")
    public ResponseEntity<List<Program>> getPrograms() {
        List<Program> allPrograms = programService.getAllPrograms();
        return new ResponseEntity<List<Program>>(allPrograms, HttpStatus.OK);
    }

    @GetMapping("/programs/{programId}")
    public ResponseEntity<Program> getProgramsById(@PathVariable String programId) throws Exception {
        Program programById = programService.getProgramById(programId);
        if(programById==null)
            throw new Exception();
        return new ResponseEntity<Program>(programById, HttpStatus.OK);
    }


    @PutMapping("/programs")
    public ResponseEntity<Program> updateProgram(@RequestBody Program program) {
        Program updatedProgram = programService.updateProgram(program);
        return new ResponseEntity<Program>(updatedProgram, HttpStatus.OK);
    }

    @DeleteMapping("/programs/{programId}")
    public ResponseEntity<List<Program>> deleteProgram(@PathVariable String programId) throws Exception {
        if(programService.getProgramById(programId)==null)
            throw new Exception();
        programService.deleteProgram(programId);
        List<Program> allPrograms = programService.getAllPrograms();
        return new ResponseEntity<List<Program>>(allPrograms, HttpStatus.OK);

    }

}
