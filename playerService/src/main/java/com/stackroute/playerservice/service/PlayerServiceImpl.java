package com.stackroute.playerservice.service;

import com.stackroute.playerservice.domain.Player;
import com.stackroute.playerservice.exceptions.PlayerAlreadyExistsException;
import com.stackroute.playerservice.exceptions.PlayerNotFoundException;
import com.stackroute.playerservice.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Services to handle all player requests -
 * add
 * remove
 * update
 * get all players
 * get by id
 * get by name
 */
@Service
public class PlayerServiceImpl implements PlayerService {



    private PlayerRepository playerRepository;

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    /**
     * Service to save a new player
     * @param player
     * @return Player
     * @throws PlayerAlreadyExistsException
     */
    public Player savePlayer(Player player) throws PlayerAlreadyExistsException{

        Player savedPlayer = null;
        if (playerRepository.existsById(player.getId())) {
//            System.out.println("***exists *******************************************");
            throw new PlayerAlreadyExistsException("test");
        }

        else {
            savedPlayer = playerRepository.save(new Player(player.getName(),player.getScore()));
            if (savedPlayer == null)
                throw new PlayerAlreadyExistsException("test");
        }
        return savedPlayer;
//        throw new PlayerAlreadyExistsException("test");
    }

    /**
     * Service to get a list of all players
     * @return List of players
     */
    public List<Player> getPlayers() {

        return (List<Player>) playerRepository.findAll();

    }

    /**
     * Service to get a player by id
     * @param id
     * @return Player
     * @throws PlayerNotFoundException
     */
    public Player getById(String id) throws PlayerNotFoundException {

        Optional<Player> user_id = playerRepository.findById(id);


        if (!user_id.isPresent())
            throw new PlayerNotFoundException("Record not found");

        return user_id.get();

    }


    /**
     * Service to delete a player using id
     * @param id
     * @throws PlayerNotFoundException
     */
    public void deleteById(String id) throws PlayerNotFoundException {

        Optional<Player> user_id = playerRepository.findById(id);
        if (!user_id.isPresent())
            throw new PlayerNotFoundException("Record not found");

        playerRepository.deleteById(id);
    }


    /**
     * Service to uodate a player by id
     * @param player
     * @param id
     * @throws PlayerNotFoundException
     */
    public void updateById(Player player, String id) throws PlayerNotFoundException {

        Optional<Player> userOptional = playerRepository.findById(id);
        if (!userOptional.isPresent())
            throw new PlayerNotFoundException("Record not found");

        player.setId(id);
        playerRepository.save(player);
    }


    /**
     * Service to get a list of players by name
     * @param name
     * @return list of players
     */
//    public List<Player> getBYName(String name) {
////        List<Player> user_id = playerRepository.findByName(name);
//        List<Player> user_id = playerRepository.findByName(name);
//        return user_id;
//    }



}
