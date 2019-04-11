package com.stackroute.programservice.service;

import com.stackroute.programservice.domain.Program;
import com.stackroute.programservice.repository.ProgramRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgramServiceImpl implements ProgramService {
    private ProgramRepository programRepository;

    public ProgramServiceImpl(ProgramRepository programRepository) {
        this.programRepository = programRepository;
    }

    @Override
    public Program saveProgram(Program program) {
        return (programRepository.save(program));
    }

    @Override
    public List<Program> getAllPrograms() {
        return (programRepository.findAll());
    }

    @Override
    public Program getProgramById(String programId) {
        return programRepository.findById(programId).get();
    }

    @Override
    public Program updateProgram(Program program) {
        return (programRepository.save(program));
    }

    @Override
    public void deleteProgram(String programId) {
        programRepository.deleteById(programId);
    }
}
