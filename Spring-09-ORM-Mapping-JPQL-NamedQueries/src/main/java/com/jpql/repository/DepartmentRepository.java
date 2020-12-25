package com.jpql.repository;

import com.jpql.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,String> {

    @Query("SELECT d FROM Department d WHERE d.division IN ?1")
    List<Department> getDepartmentByDivisionIn(List<String> division);

    List<Department> retrieveDepartmentByDivision(String division);


}
