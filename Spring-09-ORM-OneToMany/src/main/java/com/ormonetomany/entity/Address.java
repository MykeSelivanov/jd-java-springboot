package com.ormonetomany.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Address {

    @Id
    private Long id;

    private String street;
    private String zipCode;

    @ManyToOne
    private Person person;

}
