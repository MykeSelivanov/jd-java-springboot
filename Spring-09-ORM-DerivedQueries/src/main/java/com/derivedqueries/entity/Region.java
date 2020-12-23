package com.derivedqueries.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "regions")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Region extends BaseEntity {

    private String region;
    private String country;


}
