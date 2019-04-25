package com.stackroute.programservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.programservice.component.RabbitProducer;
import com.stackroute.programservice.domain.Program;
import com.stackroute.programservice.service.ProgramService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest
public class ProgramControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private Program program;
    @MockBean
    private ProgramService programService;
    @MockBean
    private RabbitProducer rabbitProducer;
    @InjectMocks
    private ProgramController programController;

    private List<Program> list = null;

    @Before
    public void setUp() {

        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(programController).build();
        program = new Program();
        program.setProgramId("1");
        program.setProgramName("Yoga");
        program.setImageUrl("image");
        program.setProgramDescription("Demo desc");
        list = new ArrayList();
        list.add(program);
    }

    @Test
    public void saveProgram() throws Exception {
        when(programService.saveProgram(any())).thenReturn(program);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/program")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(program)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andDo(MockMvcResultHandlers.print());
    }


    @Test
    public void getAllPrograms() throws Exception {
        when(programService.getAllPrograms()).thenReturn(list);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/programs")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(program)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());

    }

    @Test
    public void getProgramsById() throws Exception {
        when(programService.getProgramById("1")).thenReturn(program);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/programs/1")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(program)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());

    }


    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
