package com.jpql.repository;

import com.jpql.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.annotation.security.PermitAll;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    @Query("SELECT e FROM Employee e WHERE e.email = 'dtrail8@tamu.edu'")
    Employee getEmployeeDetail();

    @Query("SELECT e.salary FROM Employee e WHERE e.email = 'dtrail8@tamu.edu'")
    BigDecimal getEmployeeSalary();

    // single bind positional parameter

    @Query("SELECT e FROM Employee e WHERE e.email = ?1")
    Optional<Employee> getEmployeeByEmail(String email);

    // multiple bind positional parameters
    @Query("SELECT e FROM Employee e WHERE e.email = ?1 AND e.salary = ?2")
    Optional<Employee> getEmployeeByEmailAndSalary(String email, BigDecimal salary);

    // single named parameter
    @Query("SELECT e FROM Employee e WHERE e.salary = :salary")
    Optional<Employee> getEmployeeBySalary(@Param("salary") BigDecimal salary);

    // multiple named parameters
    @Query("SELECT e FROM Employee e WHERE e.firstName = :name OR e.salary = :salary")
    List<Employee> getEmployeeByFirstNameOrSalary(@Param("name") String name, @Param("salary") BigDecimal salary);

    // Not Equal
    @Query("SELECT e FROM Employee e WHERE e.salary <> ?1")
    List<Employee> getEmployeeBySalaryNotEqual(BigDecimal salary);

    // Like / Contains / StartsWith / EndsWith
    @Query("SELECT e FROM Employee e WHERE e.firstName LIKE ?1")
    List<Employee> getEmployeeByFirstNameLike(String pattern);

    // Less than
    @Query("SELECT e FROM Employee e WHERE e.salary < ?1")
    List<Employee> getEmployeeBySalaryLessThan(BigDecimal salary);

    // Greater than
    @Query("SELECT e FROM Employee e WHERE e.salary > ?1")
    List<Employee> getEmployeeBySalaryGreaterThan(BigDecimal salary);

    //Between
    @Query("SELECT e FROM Employee e WHERE e.salary BETWEEN ?1 AND ?2")
    List<Employee> getEmployeeBySalaryBetween(BigDecimal salary1, BigDecimal salary2);

    // Before
    @Query("SELECT e FROM Employee e WHERE e.hireDate > ?1")
    List<Employee> getEmployeeByHireDateBefore(LocalDate date);

    // Null
    @Query("SELECT e FROM Employee e WHERE e.email IS NULL")
    List<Employee> getEmployeeByEmailIsNull();

    // Not Null
    @Query("SELECT e FROM Employee e WHERE e.email IS NOT NULL")
    List<Employee> getEmployeeByEmailIsNotNull();

    // Sort salary in ascending order
    @Query("SELECT e FROM Employee e ORDER BY e.salary")
    List<Employee> getEmployeeBySalaryOrderByAsc();

    // Sort salary in descending order
    @Query("SELECT e FROM Employee e ORDER BY e.salary DESC")
    List<Employee> getEmployeeBySalaryOOrderByDesc();

    // Native Query
    @Query(value = "SELECT * FROM employees WHERE salary = ?1", nativeQuery = true)
    List<Employee> readEmployeeBySalary(BigDecimal salary);

    @Modifying
    @Transactional
    @Query("UPDATE Employee e SET e.email = 'admin@email.com' WHERE e.id = :id")
    void updateEmployeeJPQL(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE employees SET email = 'admin@email.com' WHERE id = :id",nativeQuery = true)
    void updateEmployeeNativeQuery(@Param("id") Long id);

    // Named Query
    List<Employee> retrieveEmployeeSalaryGreaterThan(BigDecimal salary);

}
