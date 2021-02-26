package com.cybertek.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "tags", cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private Set<Post> posts = new HashSet<>();

    public Tag(String name) {
        this.name = name;
    }

}
