package com.stackroute.playerservice.controller;

import com.stackroute.playerservice.domain.Player;
import com.stackroute.playerservice.exceptions.PlayerAlreadyExistsException;
import com.stackroute.playerservice.exceptions.PlayerNotFoundException;
import com.stackroute.playerservice.service.PlayerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Controller class for players
 * Request mapped to /api/v1/*
 */

@RefreshScope
@RestController
@CrossOrigin
@RequestMapping("api/v1")
public class PlayerController {

    private PlayerService playerService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @Value("${msg:Hello world - Config Server is not working..pelase check}")
    private String msg;

    @GetMapping("/m1")
    public ResponseEntity<String> getMsg() {
        return new ResponseEntity<String>(this.msg, HttpStatus.OK);
    }

    /**
     * autowired constructor
     *
     * @param playerService
     */
    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    /**
     * Post mapping to push player details into database
     *
     * @param player
     * @return ResponseEntity
     * @throws PlayerAlreadyExistsException
     */

    @PostMapping("/player")

    public ResponseEntity<?> savePlayer(@RequestBody Player player){
//            throws PlayerAlreadyExistsException {

//        Player savedPlayer = null;
//        savedPlayer = playerService.savePlayer(player);
//        throw new PlayerAlreadyExistsException("xx");
//
//        return new ResponseEntity<>(savedPlayer, HttpStatus.CREATED);


        ResponseEntity responseEntity;
        try {
            playerService.savePlayer(player);
            responseEntity = new ResponseEntity<String>("Successfully Created", HttpStatus.CREATED);
        } catch (PlayerAlreadyExistsException e) {
            System.out.println("msg" + e.getMessage());
            responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
            e.printStackTrace();
        }

        return responseEntity;


    }

    /**
     * Get mapping to get details of all players from the database
     *
     * @return ResponseEntity
     */

    @GetMapping("/players")

    public ResponseEntity<List<Player>> getplayers() {

        List<Player> players = playerService.getPlayers();
        logger.debug("this is a debug logger");
        logger.info("this is in info logger");
        return new ResponseEntity<List<Player>>(players, HttpStatus.OK);
    }

    /**
     * Get mapping to get details of players by Id
     *
     * @param id
     * @return ResponseEntity
     * @throws PlayerNotFoundException
     */

    @GetMapping("/player/{id}")
    public ResponseEntity<?> getById(@PathVariable String id) throws PlayerNotFoundException {

        Player player = null;
        player = playerService.getById(id);
        return new ResponseEntity<Player>(player, HttpStatus.OK);
    }

    /**
     * Delete mapping to delete by the player id
     *
     * @param id
     * @return ResponseEntity
     * @throws PlayerNotFoundException
     */

    @DeleteMapping("/player/{id}")
    public ResponseEntity<String> deletePlayer(@PathVariable String id) throws PlayerNotFoundException {
        playerService.deleteById(id);
        return new ResponseEntity<String>("Deleted", HttpStatus.OK);
    }

    /**
     * Put mapping to edit details of the existing players
     *
     * @param player
     * @param id
     * @return ResponseEntity
     */

    @PutMapping("/update/{id}")
    public ResponseEntity<Player> updatePlayer(@Valid @RequestBody Player player, @PathVariable String id) throws PlayerNotFoundException {

        playerService.updateById(player, id);

        return new ResponseEntity<Player>(player, HttpStatus.OK);
    }

    /**
     * Get mapping to get details of players by name
     *
     * @param name
     * @return ResponseEntity
     */

//    @GetMapping("/players-by-name/{name}")
//    public ResponseEntity<List<Player>> getPlayerByName(@PathVariable String name) {
//        List<Player> players = playerService.getBYName(name);
//        return new ResponseEntity<List<Player>>(players, HttpStatus.OK);
//    }
}
