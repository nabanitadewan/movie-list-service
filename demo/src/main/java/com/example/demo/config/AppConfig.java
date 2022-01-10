package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class AppConfig {
    @Bean
    public WebClient webClient(WebClient.Builder builder) {
        return builder.baseUrl("https://api.themoviedb.org/3/")
                .defaultHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJhN2IzOWU4NDU2OWE3ZWRlZGEwYmNjYjg1ODE4M2EwYyIsInN1YiI6IjYxZGM1ODhmYmRkNTY4MDA2YzZhMDg3MyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.l-tkJkYfKWn1xIyZ2C0uY3QiQacxUrtKm0Cr9xO4gqE").build();
    }
}
