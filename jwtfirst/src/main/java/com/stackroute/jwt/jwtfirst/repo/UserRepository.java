package com.stackroute.jwt.jwtfirst.repo;

import com.stackroute.jwt.jwtfirst.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    User findByEmailIgnoreCase(String username);
}
