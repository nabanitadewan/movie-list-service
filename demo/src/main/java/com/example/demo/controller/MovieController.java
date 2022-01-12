package com.example.demo.controller;

import com.example.demo.dto.SimpleSource;
import com.example.demo.entity.Movie;
import com.example.demo.mapper.MovieMapper;
import com.example.demo.repository.MovieRepository;
import com.example.demo.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movie")
@Slf4j
public class MovieController {
    @Autowired
    private MovieService movieService;

    @Autowired
    private MovieMapper movieMapper;

    @Autowired
    private MovieRepository movieRepository;

    @PostMapping("/save")
    public Movie saveMovie(@RequestBody SimpleSource simpleSource) {
        Movie movie = movieMapper.sourceToDestination(simpleSource);
        return movieService.saveMovie(movie);
    }

    @GetMapping("/popular")
    public Object getPopularMovies() {
        return movieService.getPopularMovies();
    }

    @GetMapping("/allUserMovies/{id}")
    public List<Movie> getAllUserMovies(@PathVariable("id") String id){
        return  movieService.getAllUserMovies(id);
    }

    @PutMapping(value = "/update/{id}")
    public @ResponseBody
    Optional<Movie> updateMovie(@PathVariable("id") Long id, @RequestBody SimpleSource simpleSource) {
        return movieService.updateMovieRating(id,simpleSource);
    }

}
