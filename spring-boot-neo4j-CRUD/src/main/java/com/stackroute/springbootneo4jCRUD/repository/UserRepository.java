package com.stackroute.springbootneo4jCRUD.repository;

import com.stackroute.springbootneo4jCRUD.domain.Session;
import com.stackroute.springbootneo4jCRUD.domain.User;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends Neo4jRepository<User, Long> {
    @Query("MATCH (u:User)-[l:likes]->(m:Session) RETURN u,l,m")
    Iterable<User> getAllUsers();

    @Query("match (d:Users) CREATE (u:User{name:({name}),age:({age})}) create (d)-[r:hasUser]->(u) return u")
    User saveUserDetails(String name, int age);

    @Query("MATCH (n) DETACH DELETE n")
    void deleteAllNodesAndRelationship();

    @Query("MATCH (n:User{name:({name})})-[r:follows]->(m:User) MATCH (m)-[follows]->(h:User) return h")
    Iterable<User> followUsers(String name);

    @Query("MATCH (n:User{name:({name})})-[r:follows]->(m:User) MATCH (m)-[likes]->(h:Session) return h")
    Iterable<Session> recommend(String name);

    @Query("Match (n:User),(m:User) where n.name=({name1}) and m.name=({name2}) create (n)-[r:follows]->(m)")
    void saveRelation(String name1, String name2);

    @Query("match (Session {name:({name})})<-[r:likes]-(n:User) return n")
    Iterable<User> recommendUsers(String name);

    @Query("Match (n:User),(m:Session) where n.name=({username}) and m.name=({sessionname}) create (n)-[r:likes]->(m)")
    void saveRelationLikes(String username, String sessionname);

    @Query("Match(h:User),(k:User) where h.name=({name}) and (k.age=h.age-1 or k.age=h.age+1) return k")
    Iterable<User> agegroup(String name);

    @Query("match(:User{name:({name1})})-[r:follows]-(:User{name:({name2})}) delete r")
    void unfollow(String name1, String name2);

    @Query("MATCH (u:User{name:({name})})-[l:follows]->(m:User) RETURN u,l,m")
    Iterable<User> userfollow(String name);
}

