package com.stackroute.userauthentication.repo;

import com.stackroute.userauthentication.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User findByEmailIgnoreCase(String username);
}
