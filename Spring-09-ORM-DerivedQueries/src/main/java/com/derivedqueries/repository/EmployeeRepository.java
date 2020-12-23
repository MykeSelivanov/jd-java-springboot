package com.derivedqueries.repository;

import com.derivedqueries.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    // Display all employees with email address ''
    List<Employee> findByEmail(String email);

    // Display all employees with first name '' and last name '', also show all employees with a email address ''
    List<Employee> findByFirstNameAndLastNameOrEmail(String firstName, String lastName, String email);

    // Display all employees that first name is not ''
    List<Employee> findByFirstNameIsNot(String firstName);

    // Display all employees where last name starts with ''
    List<Employee> findByLastNameStartingWith(String pattern);

    // Display all employees with salaries higher than ''
    List<Employee> findBySalaryGreaterThan(BigDecimal salary);

    // Display all employees with salaries less than ''
    List<Employee> findBySalaryLessThanEqual(BigDecimal salary);

    // Display all employees that has been hired between '' and ''
    List<Employee> findByHireDateBetween(LocalDate start,LocalDate end);

    // Display all employees where salaries greater and equal to '' in order
    List<Employee> findBySalaryIsGreaterThanEqualOrderBySalaryDesc(BigDecimal salary);

    // Display top unique 3 employees that is making less than ''
    List<Employee> findDistinctTop3BySalaryLessThanEqual(BigDecimal salary);

    // Display all employees that do not have email address
    List<Employee> findByEmailIsNull();









}
