package com.cinemaapp.entity;

import com.cinemaapp.enums.MovieState;
import com.cinemaapp.enums.MovieType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Movie extends BaseEntity {

    private String name;

    @Column(columnDefinition = "DATE")
    private LocalDate releaseDate;

    private Integer duration;

    @Column(columnDefinition = "text")
    private String summary;

    @Enumerated(EnumType.STRING)
    private MovieType type;
    @Enumerated(EnumType.STRING)
    private MovieState state;

    private BigDecimal price;

    @ManyToMany
    @JoinTable(name = "movie_genre_rel",
    joinColumns = @JoinColumn(name = "movie_id"),
    inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private Set<Genre> genreList = new HashSet<>();

    public Movie(String name, LocalDate releaseDate, Integer duration, MovieType type, MovieState state, BigDecimal price) {
        this.name = name;
        this.releaseDate = releaseDate;
        this.duration = duration;
        this.summary = summary;
        this.type = type;
        this.state = state;
        this.price = price;
    }






}
