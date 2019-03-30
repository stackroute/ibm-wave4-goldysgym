package com.stackroute.adminservice.controller;

import com.stackroute.adminservice.domain.Program;
import com.stackroute.adminservice.service.ProgramService;
import com.stackroute.adminservice.service.ProgramServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.naming.ldap.PagedResultsControl;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class ProgramController {
    private ProgramService programService;

    public ProgramController(ProgramService programServiceImpl) {
        this.programService = programServiceImpl;
    }

    @PostMapping("/program")
    public ResponseEntity<Program> saveProgram(@RequestBody Program program) {
        Program programAdded = programService.saveProgram(program);
        return new ResponseEntity<Program>(programAdded, HttpStatus.CREATED);
    }

    @GetMapping("/programs")
    public ResponseEntity<List<Program>> getPrograms() {
        List<Program> allPrograms = programService.getAllPrograms();
        return new ResponseEntity<List<Program>>(allPrograms, HttpStatus.OK);
    }

    @GetMapping("/programs/{programId}")
    public ResponseEntity<Program> getProgramsById(@PathVariable String programId){
        Program programById=programService.getProgramById(programId);
        return new ResponseEntity<Program>(programById,HttpStatus.FOUND);
    }


    @PutMapping("/programs/")
    public ResponseEntity<Program> updateProgram(@RequestBody Program program) {
        Program updatedProgram = programService.updateProgram(program);
        return new ResponseEntity<Program>(updatedProgram, HttpStatus.OK);
    }

    @DeleteMapping("/programs/{programId}")
    public ResponseEntity<List<Program>> deleteProgram(@PathVariable String programId) {
        programService.deleteProgram(programId);
        List<Program> allPrograms = programService.getAllPrograms();
        return new ResponseEntity<List<Program>>(allPrograms, HttpStatus.OK);

    }

}
