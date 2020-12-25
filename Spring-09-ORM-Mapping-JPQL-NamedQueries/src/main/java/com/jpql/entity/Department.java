package com.jpql.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "departments")
@Getter
@Setter
@NoArgsConstructor
@ToString
@NamedQuery(name = "Department.findMykeDepartment",
            query = "SELECT d FROM Department d WHERE d.division = ?1")
@NamedNativeQuery(name = "Department.countAllDepartments",
                  query = "SELECT * FROM departments",
                  resultClass = Department.class)
public class Department {

    @Id
    private String department;
    private String division;


}
