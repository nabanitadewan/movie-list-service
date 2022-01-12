package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "user_movie")
@Data
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "userId")
    String userId;
    @Column(name = "movieId")
    String movieId;
    @Column(name = "rating")
    String rating;

}
