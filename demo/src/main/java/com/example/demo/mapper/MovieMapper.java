package com.example.demo.mapper;

import com.example.demo.dto.SimpleSource;
import com.example.demo.entity.Movie;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MovieMapper {
    Movie sourceToDestination(SimpleSource source);
}

