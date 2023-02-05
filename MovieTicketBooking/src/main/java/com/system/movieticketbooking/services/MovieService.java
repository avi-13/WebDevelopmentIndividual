package com.system.movieticketbooking.services;

import com.system.movieticketbooking.pojo.MoviePojo;

import java.io.IOException;

public interface MovieService {
    MoviePojo saveMovie(MoviePojo moviePojo) throws IOException;
}
