package com.example.demo.service;

import com.example.demo.entity.Movie;
import com.example.demo.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

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
}
