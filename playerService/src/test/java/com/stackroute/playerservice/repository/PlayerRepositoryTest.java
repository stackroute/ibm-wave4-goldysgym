package com.stackroute.playerservice.repository;

import com.stackroute.playerservice.domain.Player;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataMongoTest
public class PlayerRepositoryTest {

    @Autowired
    private PlayerRepository playerRepository;

    private Player player;

    @Before
    public void setUp() throws Exception {
        player = new Player("1", "Shaikh", 100);

    }

    @After
    public void tearDown() throws Exception {
        playerRepository.deleteAll();
    }


    @Test
    public void testSavePlayer() {
        playerRepository.save(player);
        Player fetchUser = playerRepository.findById(player.getId()).get();
        Assert.assertEquals("1", fetchUser.getId());
    }

    @Test
    public void testSavePlayerName() {
        playerRepository.save(player);
        Player fetchUser = playerRepository.findById(player.getId()).get();
        Assert.assertEquals("Shaikh", fetchUser.getName());
    }

    @Test
    public void testSaveUserFailure() {
        Player testUser = new Player("2", "Farhaan", 200);
        playerRepository.save(player);
        Player fetchUser = playerRepository.findById(player.getId()).get();
        Assert.assertNotSame(testUser, player);
    }

    @Test
    public void testGetAllUser() {
        Player p1 = new Player("1", "Johny", 1020);
        Player p2 = new Player("2", "Harry", 1030);
        playerRepository.save(p1);
        playerRepository.save(p2);

        List<Player> list = playerRepository.findAll();
        Assert.assertEquals("Johny", list.get(0).getName());

    }
}