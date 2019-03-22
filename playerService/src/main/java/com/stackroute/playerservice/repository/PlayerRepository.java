package com.stackroute.playerservice.repository;

import com.stackroute.playerservice.domain.Player;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;

/**
 * Player repository to query player information
 */

public interface PlayerRepository extends MongoRepository<Player, String> {

//    @Query(
//            value = "SELECT * FROM PLAYER where name = ?1",
//            nativeQuery = true)
//    List<Player> findAllActiveUsers(String name);
//    @Query(value = "SELECT p FROM Player p where p.name =?1")
//    List<Player> findByName(String name);
}
