package com.cinemaapp.repository;

import com.cinemaapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    //-------------------------DERIVED QUERIES-------------------------

    //Write a derived query to read a user with an email?
    Optional<User> findByEmail(String email);

    //Write a derived query to read a user with a username?
    Optional<User> findByUsername(String userName);

    //Write a derived query to list all users that contain a specific name?
    List<User> findAllByUsernameContaining(String pattern);

    //Write a derived query to list all users that contain a specific name in the ignore case mode?
    List<User> findAllByUsernameContainingIgnoreCase(String userName);

    //Write a derived query to list all users with an age greater than a specified age?
    List<User> findAllByAccountAgeIsGreaterThanEqual(Integer age);

    //--------------JPQL-----------------------------------------

    //Write a JPQL query that returns a user read by email?
    @Query("SELECT u FROM User u WHERE u.email = ?1")
    Optional<User> fetchUserByEmail(String email);

    //Write a JPQL query that returns a user read by username?
    @Query("SELECT u FROM User u WHERE u.username = ?1")
    Optional<User> fetchUserByUsername(String userName);

    //Write a JPQL query that returns all users?
    @Query("SELECT u FROM User u")
    List<User> fetchAllUsers();

    //--------------------------------------NATIVE-------------

    //Write a native query that returns all users that contain a specific name?


    //Write a native query that returns all users?


    //Write a native query that returns all users in the range of ages?


    //Write a native query to read a user by email?





}
