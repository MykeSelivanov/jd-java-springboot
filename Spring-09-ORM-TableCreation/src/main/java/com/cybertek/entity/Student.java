package com.cybertek.entity;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    @Column(name = "studentFirstName")
    private String firstName; //first_name
    @Column(name = "studentLastName")
    private String lastName;
    @Column(name = "studentEmailAddress")
    private String email;

    @Transient
    private String city;

}
