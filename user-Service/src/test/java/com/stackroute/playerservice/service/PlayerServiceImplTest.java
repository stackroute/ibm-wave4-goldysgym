package com.stackroute.playerservice.service;

import com.stackroute.playerservice.domain.Player;
import com.stackroute.playerservice.exceptions.PlayerAlreadyExistsException;
import com.stackroute.playerservice.repository.PlayerRepository;
import org.junit.After;
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

public class PlayerServiceImplTest {


    private Player player;

    //Create a mock for UserRepository
    @Mock
    private PlayerRepository playerRepository;

    //Inject the mocks as dependencies into UserServiceImpl
    @InjectMocks
    private PlayerServiceImpl playerService;
    List<Player> list= null;


    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);
        player = new Player("1","John",110211);
//        player.see("John");
//        player.setId(101);
//        player.setFirstName("Jenny");
//        player.setAge(10);
        list = new ArrayList<>();
        list.add(player);

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void savePlayer() throws PlayerAlreadyExistsException {

        when(playerRepository.save((Player)any())).thenReturn(player);
        Player savedplayer = playerService.savePlayer(player);
        Assert.assertEquals(player,savedplayer);
        //verify here verifies that userRepository save method is only called once
        verify(playerRepository,times(1)).save(player);


    }

//    PlayerAlreadyExistsException p;

    @Test(expected = PlayerAlreadyExistsException.class)
    public void saveUserTestFailure() throws PlayerAlreadyExistsException {
        when(playerRepository.save((Player)any())).thenReturn(null);
        Player savedPlayer = playerService.savePlayer(player);
        System.out.println("savedPlayer " + savedPlayer);
        Assert.assertEquals(player,savedPlayer);

        System.out.println(playerRepository.count());
       /*doThrow(new UserAlreadyExistException()).when(userRepository).findById(eq(101));
       userService.saveUser(user);*/


    }

    @Test
    public void getAllUser(){

        playerRepository.save(player);
        //stubbing the mock to return specific data
        when(playerRepository.findAll()).thenReturn(list);
        List<Player> userlist = playerService.getPlayers();
        Assert.assertEquals(list,userlist);
    }

    @Test
    public void getPlayers() {
    }

    @Test
    public void getById() {
    }

    @Test
    public void deleteById() {
    }

    @Test
    public void updateById() {
    }
}