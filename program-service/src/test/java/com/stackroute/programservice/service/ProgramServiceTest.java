package com.stackroute.programservice.service;

import com.stackroute.programservice.component.RabbitProducer;
import com.stackroute.programservice.domain.Program;
import com.stackroute.programservice.repository.ProgramRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

public class ProgramServiceTest {

    private Program program;

    //Create a mock for UserRepository
    @Mock
    private ProgramRepository programRepository;
    @Mock
    private RabbitProducer rabbitProducer;
    //Inject the mocks as dependencies into UserServiceImpl
    @InjectMocks
    private ProgramServiceImpl programServiceImpl;
    List<Program> list = null;


    @Before
    public void setUp() {
        //Initialising the mock object
        MockitoAnnotations.initMocks(this);
        program = new Program();
        program.setProgramId("1");
        program.setProgramName("Yoga");
        program.setImageUrl("xyz");
        program.setProgramDescription("hjh");
        list = new ArrayList<>();
        list.add(program);


    }

    @Test
    public void saveUserTestSuccess() {

        when(programRepository.save((Program) any())).thenReturn(program);
        Program savedProgram = programServiceImpl.saveProgram(program);
        Assert.assertEquals(program, savedProgram);

        //verify here verifies that userRepository save method is only called once
        verify(programRepository, times(1)).save(program);

    }

    @Test
    public void saveUserTestFailure() {
        when(programRepository.save((Program) any())).thenReturn(null);
        Program savedProgram = programServiceImpl.saveProgram(program);
        System.out.println("savedUser" + savedProgram);
        Assert.assertNotEquals(program, savedProgram);

       /*doThrow(new UserAlreadyExistException()).when(userRepository).findById(eq(101));
       userService.saveUser(user);*/


    }

    @Test
    public void getAllPrograms() {

        programRepository.save(program);
        //stubbing the mock to return specific data
        when(programRepository.findAll()).thenReturn(list);
        List<Program> userlist = programServiceImpl.getAllPrograms();
        Assert.assertEquals(list, userlist);
    }


}
