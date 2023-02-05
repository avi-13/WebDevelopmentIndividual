package com.system.movieticketbooking.services.impl;

import com.system.movieticketbooking.entity.Movie;
import com.system.movieticketbooking.pojo.MoviePojo;
import com.system.movieticketbooking.repo.MovieRepo;
import com.system.movieticketbooking.services.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {
    private final MovieRepo movieRepo;
    public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/images";

    @Override
    public MoviePojo saveMovie(MoviePojo moviePojo) throws IOException {
        Movie movie = new Movie();
        if (moviePojo.getMovieId() != null){
            movie.setId(moviePojo.getMovieId());
        }
        movie.setMovieName(moviePojo.getMovieName());
        movie.setMovieDescription(moviePojo.getMovieDescription());
        movie.setCast(moviePojo.getCast());
        movie.setDirector(moviePojo.getDirector());
        movie.setDuration(moviePojo.getDuration());
        movie.setReleaseDate(moviePojo.getReleaseDate());
        movie.setGenre(moviePojo.getGenre());
        movie.setCategory(moviePojo.getCategory());
        movie.setShows(moviePojo.getShows());

        if(moviePojo.getImage()!=null){
//            System.out.println(UPLOAD_DIRECTORY);
            StringBuilder fileNames = new StringBuilder();
            Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, moviePojo.getImage().getOriginalFilename());
            fileNames.append(moviePojo.getImage().getOriginalFilename());
            Files.write(fileNameAndPath, moviePojo.getImage().getBytes());

            movie.setImage(moviePojo.getImage().getOriginalFilename());
        }
        movieRepo.save(movie);
        return new MoviePojo(movie);
    }
}
