package com.system.movieticketbooking.services;

import com.system.movieticketbooking.entity.Movie;
import com.system.movieticketbooking.pojo.MoviePojo;

import java.io.IOException;
import java.util.List;

public interface MovieService {
    MoviePojo saveMovie(MoviePojo moviePojo) throws IOException;

    Movie fetchById(Integer id);

    List<Movie> fetchAll();

    void deleteById(Integer id);
}
