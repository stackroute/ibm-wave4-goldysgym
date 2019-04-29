package com.stackroute.springbootneo4jCRUD.repository;

import com.stackroute.springbootneo4jCRUD.domain.Session;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepsository extends Neo4jRepository<Session, Long> {
    @Query("match (n:Programs) CREATE (m:Session{name:({name}),imageUrl:({imageUrl})}) create (n)-[r:hasProgram]->(m) return n,r,m")
    Session saveSessionDetails(String name,String imageUrl);

    @Query("MATCH (m:Session) RETURN m")
    Iterable<Session> getAllSessions();
}
