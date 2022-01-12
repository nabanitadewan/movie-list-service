package com.example.demo.service;

import com.example.demo.dto.SimpleSource;
import com.example.demo.entity.Movie;
import com.example.demo.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepo;

    @Autowired
    private WebClient webClient;

    public Movie saveMovie(Movie movie) {

        return movieRepo.save(movie);
    }

    public Object getPopularMovies() {
        return webClient.get()
                .uri("movie/popular?api_key=a7b39e84569a7ededa0bccb858183a0c")
                .retrieve()
                .bodyToMono(Object.class)
                .block();
    }

    public List<Movie> getAllUserMovies(String id){
        List<Movie> movies = new ArrayList<>();
        movieRepo.findAll().forEach(movie -> {
                    if(movie.getUserId().equals(id))
                        movies.add(movie);
                }
        );
        return movies;
    }

    public Optional<Movie> updateMovieRating(long id, SimpleSource simpleSource){
        return movieRepo.findById(id).map(movie -> {
            movie.setRating(simpleSource.getRating());
            return movieRepo.save(movie);
        });
    }
}
