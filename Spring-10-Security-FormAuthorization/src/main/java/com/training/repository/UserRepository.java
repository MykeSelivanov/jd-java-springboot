package com.training.repository;

import com.training.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    // Find user in DB with username
    User findByUsername(String username);

}
