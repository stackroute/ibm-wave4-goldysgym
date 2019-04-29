package com.stackroute.springbootneo4jCRUD.service;
import com.stackroute.springbootneo4jCRUD.domain.Program;
import com.stackroute.springbootneo4jCRUD.domain.Session;
import com.stackroute.springbootneo4jCRUD.domain.User;
import com.stackroute.springbootneo4jCRUD.domain.UserDetails;
import com.stackroute.springbootneo4jCRUD.repository.SessionRepsository;
import com.stackroute.springbootneo4jCRUD.repository.UserRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private SessionRepsository sessionRepsository;

    @Autowired
    public UserServiceImpl(UserRepository userRepositry,SessionRepsository sessionRepsository){
        this.userRepository=userRepositry;
        this.sessionRepsository=sessionRepsository;
    }

    @Override
    public User saveUser(UserDetails user) {
        User saveUser = userRepository.saveUserDetails(user.getName(),user.getAge());
        return saveUser;
    }


    @Override
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Session saveSession(Session session) {
        Session saveSession = (Session) sessionRepsository.saveSessionDetails(session.getName(),session.getImageUrl());
        return saveSession;
    }

    @Override
    public Iterable<Session> getAll() {
        System.out.println(userRepository.findAll());
        return sessionRepsository.findAll();
    }

    @Override
    public void deleteData() {
        userRepository.deleteAllNodesAndRelationship();
    }

    @Override
    public Iterable<Session> getAllSessions() {
       return sessionRepsository.getAllSessions();
    }

    @Override
    public Iterable<User> followUsers(String name) {
        return  userRepository.followUsers(name);
    }

    @Override
    public Iterable<Session> recommend(String name) {
        return userRepository.recommend(name);
    }

    @Override
    public Iterable<User> recommendUser(String name) {
        return userRepository.recommendUsers(name);
    }

    @Override
    public void saveRelationLikes(String username, String sessionname) {
            userRepository.saveRelationLikes(username,sessionname);
    }
    @Override
    public Iterable<User> agegroup(String name) {
        return userRepository.agegroup(name);
    }

    @Override
    public void saveRelation(String name1, String name2) {
            userRepository.saveRelation(name1,name2);
    }

    @Override
    public void unfollow(String name1, String name2) {
            userRepository.unfollow(name1,name2);
    }

    @Override
    public Iterable<User> userfollow(String name) {
        return userRepository.userfollow(name);
    }

}
