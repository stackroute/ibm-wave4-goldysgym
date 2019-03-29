package com.stackroute.adminservice.repository;

import com.stackroute.adminservice.domain.Program;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataMongoTest
public class ProgramRepositoryTest {

    @Autowired
    private ProgramRepository programRepository;
    private Program program;

    @Before
    public void setUp() {
        program = new Program();
        program.setProgramId("1");
        program.setProgramName("Yoga");
        program.setDay("Monday");
        program.setTiming("Morning");
        program.setImageUrl("xyz");
        program.setProgramDescription("hjh");
        program.setTrainerName("Rohan");
        program.setTrainerDescription("asdd");
        program.setTotalSeats(20);


    }

    @After
    public void tearDown() {

        programRepository.deleteAll();
    }


    @Test
    public void testSaveProgram() {
        programRepository.save(program);
        Program fetchProgram = programRepository.findById(program.getProgramId()).get();
        Assert.assertEquals("1", fetchProgram.getProgramId());

    }

    @Test
    public void testSaveProgramFailure() {
        Program testProgram = new Program("2", "Zumba", "Saturday", "Evening", "fhfh", "hjhh", "Rohan", "fdfd", 20);
        programRepository.save(program);
        Program fetchProgram = programRepository.findById(program.getProgramId()).get();
        Assert.assertNotSame(testProgram, program);
    }

    @Test
    public void testGetAllProgram() {
        Program testProgram = new Program("2", "Zumba", "Saturday", "Evening", "fhfh", "hjhh", "Rohan", "fdfd", 20);
        Program testProgram1 = new Program("3", "Zumba", "Sunday", "Evening", "fhfh", "hjhh", "Rohit", "fdfd", 25);
        programRepository.save(testProgram);
        programRepository.save(testProgram1);

        List<Program> list = programRepository.findAll();
        Assert.assertEquals("Zumba", list.get(0).getProgramName());


    }

}
