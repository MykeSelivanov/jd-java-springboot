package com.restwebflux.repository;

import com.restwebflux.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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
    @Query(value = "SELECT * FROM user_account ua JOIN account_details ad ON ua.account_details_id = ad.id " +
            "WHERE ad.name ILIKE concat('%',?1,'%')", nativeQuery = true)
    List<User> retrieveUsersWithNameContains(String pattern);

    //Write a native query that returns all users?
    @Query(value = "SELECT * FROM user_account", nativeQuery = true)
    List<User> retrieveAllUsers();

    //Write a native query that returns all users in the range of ages?
    @Query(value = "SELECT * FROM user_account ua JOIN account_details ad ON ua.account_details_id = ad.id " +
            "WHERE ad.age BETWEEN ?1 AND ?2", nativeQuery = true)
    List<User> retrieveAllUsersInTheAgeRange(Integer age1, Integer age2);

    //Write a native query to read a user by email?
    @Query(value = "SELECT * FROM account_details ad JOIN user_account ua ON ad.id = ua.account_details_id " +
            "WHERE ua.email = :email", nativeQuery = true)
    Optional<User> retrieveUserByEmail(@Param("email") String email);




}
