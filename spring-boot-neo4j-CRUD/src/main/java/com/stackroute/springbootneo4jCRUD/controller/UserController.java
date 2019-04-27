package com.stackroute.springbootneo4jCRUD.controller;

import com.stackroute.springbootneo4jCRUD.domain.Program;
import com.stackroute.springbootneo4jCRUD.domain.Session;
import com.stackroute.springbootneo4jCRUD.domain.User;
import com.stackroute.springbootneo4jCRUD.domain.UserDetails;
import com.stackroute.springbootneo4jCRUD.service.UserService;
import com.stackroute.springbootneo4jCRUD.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/user/api/v1")
public class UserController {
    private UserService userService;
    private UserDetails userDetails;

    @Autowired
    public UserController(UserServiceImpl userServiceImpl){
        this.userService=userServiceImpl;
    }

    /*Mapping of Saveplayer Details Method*/
    @PostMapping("/user")
    public ResponseEntity<String> saveUser(@RequestBody UserDetails userDetails) {
        ResponseEntity responseEntity;
        userService.saveUser(userDetails);
        responseEntity = new ResponseEntity<String>("Succesfully added", HttpStatus.CREATED);
        return responseEntity;
    }
    @PostMapping("/session")
    public ResponseEntity<String> saveSession(@RequestBody Session session) {
        ResponseEntity responseEntity;
        userService.saveSession(session);
        responseEntity = new ResponseEntity<String>("Succesfully added", HttpStatus.CREATED);
        return responseEntity;
    }
//creating follow relationship
    @PostMapping("/relation/{name1}/{name2}")
    public ResponseEntity<String> saveRelation(@PathVariable String name1,@PathVariable String name2) {
        ResponseEntity responseEntity;
        userService.saveRelation(name1,name2);
        responseEntity = new ResponseEntity<String>("Succesfully added", HttpStatus.CREATED);
        return responseEntity;
    }
    //creating likes relationship
    @PostMapping("/likes/program/{username}/{sessionname}")
    public ResponseEntity<String> saveRelationLikes(@PathVariable String username, @PathVariable String sessionname) {
        ResponseEntity responseEntity;
        userService.saveRelationLikes(username,sessionname);
        responseEntity = new ResponseEntity<String>("Succesfully added", HttpStatus.CREATED);
        return responseEntity;
    }

    @GetMapping("/users")
    public ResponseEntity<Iterable<User>> getAllUsers() {
        Iterable<User> allUsers = userService.getAllUsers();
        return new ResponseEntity<Iterable<User>>(allUsers, HttpStatus.OK);
    }
    @GetMapping("/users/followed/{name}")
    public ResponseEntity<Iterable<User>> userfollow(@PathVariable String name) {
        Iterable<User> allUsers = (Iterable<User>) userService.userfollow(name);
        return new ResponseEntity<Iterable<User>>(allUsers, HttpStatus.OK);
    }
    @GetMapping("/followedusers/{name}")
    public ResponseEntity<Iterable<User>> followUsers(@PathVariable String name) {
        Iterable<User> allUsers =  userService.followUsers(name);
        return new ResponseEntity<Iterable<User>>(allUsers, HttpStatus.OK);
    }
    @GetMapping("/agegroup/{name}")
    public ResponseEntity<Iterable<User>> agegroup(@PathVariable String name) {
        Iterable<User> allUsers = userService.agegroup(name);
        return new ResponseEntity<Iterable<User>>(allUsers, HttpStatus.OK);
    }
    @GetMapping("/recommend/programs/{name}")
    public ResponseEntity<Iterable<Session>> recommend(@PathVariable String name) {
        Iterable<Session> allUsers = userService.recommend(name);
        return new ResponseEntity<Iterable<Session>>(allUsers, HttpStatus.OK);
    }
    @GetMapping("/recommend/users/{name}")
    public ResponseEntity<Iterable<User>> recommendUser(@RequestBody String name) {
        Iterable<User> allUsers = userService.recommendUser(name);
        return new ResponseEntity<Iterable<User>>(allUsers, HttpStatus.OK);
    }


    @GetMapping("/data")
    public ResponseEntity<Iterable<Session>> getAll() {
        Iterable<Session> allUsers = userService.getAll();
        return new ResponseEntity<Iterable<Session>>(allUsers, HttpStatus.OK);
    }

    @GetMapping("/sessions")
    public ResponseEntity<Iterable<Session>> getAllSessions() {
        Iterable<Session> allSessions = userService.getAllSessions();
        return new ResponseEntity<Iterable<Session>>(allSessions, HttpStatus.OK);
    }

    @DeleteMapping("/del")
    public void deleteData()
    {
        userService.deleteData();
    }

    @DeleteMapping("/unfollow/{name1}/{name2}")
    public void unfollow(@PathVariable String name1,@PathVariable String name2){
        userService.unfollow(name1,name2);
    }


}
