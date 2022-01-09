package com.example.demo.controller;

import com.example.demo.dto.SimpleSource;
import com.example.demo.entity.Movie;
import com.example.demo.mapper.MovieMapper;
import com.example.demo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @Autowired
    private MovieMapper movieMapper;


    @PostMapping("/save")
    public Movie saveMovie(@RequestBody SimpleSource simpleSource) {
        Movie movie=movieMapper.sourceToDestination(simpleSource);
//        movie.setName(simpleSource.getName());
        return movieService.saveMovie(movie);
    }
}
