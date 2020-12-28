package com.cinemaapp.repository;

import com.cinemaapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    //-------------------------DERIVED QUERIES-------------------------

    //Write a derived query to read a user with an email?
    Optional<User> findByEmail(String email);

    //Write a derived query to read a user with a username?
    Optional<User> findByUsername(String userName);

    //Write a derived query to list all users that contain a specific name?


    //Write a derived query to list all users that contain a specific name in the ignore case mode?


    //Write a derived query to list all users with an age greater than a specified age?


    //--------------JPQL-----------------------------------------

    //Write a JPQL query that returns a user read by email?


    //Write a JPQL query that returns a user read by username?


    //Write a JPQL query that returns all users?


    //--------------------------------------NATIVE-------------

    //Write a native query that returns all users that contain a specific name?


    //Write a native query that returns all users?


    //Write a native query that returns all users in the range of ages?


    //Write a native query to read a user by email?





}
