package com.example.demo.controller;

import com.example.demo.dto.SimpleSource;
import com.example.demo.entity.Movie;
import com.example.demo.mapper.MovieMapper;
import com.example.demo.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movie")
@Slf4j
public class MovieController {
    @Autowired
    private MovieService movieService;

    @Autowired
    private MovieMapper movieMapper;


    @PostMapping("/save")
    public Movie saveMovie(@RequestBody SimpleSource simpleSource) {
        Movie movie=movieMapper.sourceToDestination(simpleSource);
        return movieService.saveMovie(movie);
    }

    @GetMapping("/popular")
    public Object getPopularMovies() {
        return movieService.getPopularMovies();
    }
}
