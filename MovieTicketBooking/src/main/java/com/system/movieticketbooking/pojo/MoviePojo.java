package com.system.movieticketbooking.pojo;


import com.system.movieticketbooking.entity.Movie;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MoviePojo {
    private Integer movieId;

    private String movieName;

    private String movieDescription;

    private String cast;

    private String director;

    private String genre;

    private Date releaseDate;

    private String duration;

    private Integer shows;

    private String category;

    private MultipartFile image;
    private MultipartFile image1;

    public MoviePojo(Movie movie) {
        this.movieId = movie.getId();
        this.movieName = movie.getMovieName();
        this.movieDescription = movie.getMovieDescription();
        this.cast = movie.getCast();
        this.director = movie.getDirector();
        this.genre = movie.getGenre();
        this.releaseDate = movie.getReleaseDate();
        this.duration = movie.getDirector();
        this.category = movie.getCategory();
        this.shows = movie.getShows();
    }
}
