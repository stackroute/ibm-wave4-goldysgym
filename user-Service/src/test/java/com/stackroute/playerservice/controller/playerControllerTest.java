package com.stackroute.playerservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.playerservice.domain.Player;
import com.stackroute.playerservice.exceptions.PlayerAlreadyExistsException;
import com.stackroute.playerservice.service.PlayerService;
import org.junit.After;
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

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest
public class playerControllerTest {

    @Autowired
    private MockMvc mockMvc;
    private Player player;
    @MockBean
    private PlayerService playerService;
    @InjectMocks
    private PlayerController playerController;

    private List<Player> list =null;

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(playerController).build();
        player = new Player("10","Jonny",1000);
        list = new ArrayList();
        list.add(player);

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void saveUser() throws Exception {
        when(playerService.savePlayer(any())).thenReturn(player);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/player")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(player)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andDo(MockMvcResultHandlers.print());


    }


    @Test
    public void saveUserFailure() throws Exception {
        when(playerService.savePlayer(any())).thenThrow(PlayerAlreadyExistsException.class);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/player")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(player)))
                .andExpect(MockMvcResultMatchers.status().isConflict())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void getAllUser() throws Exception {
        when(playerService.getPlayers()).thenReturn(list);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/players")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(player)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());

    }

    private static String asJsonString(final Object obj)
    {
        try{
            return new ObjectMapper().writeValueAsString(obj);

        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

}