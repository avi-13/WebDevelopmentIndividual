package com.system.movieticketbooking.controller;

import com.system.movieticketbooking.entity.Movie;
import com.system.movieticketbooking.services.MovieService;
import com.system.movieticketbooking.services.UserService;
import com.system.movieticketbooking.services.impl.MovieServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/home")
public class HomepageController {
    private final MovieService movieService;
    private final UserService userService;
    private final MovieServiceImpl movieServiceImpl;

    @GetMapping("/homepage")
    public String homePage() {
        return "redirect:/movie/movieList";
    }



//    @GetMapping("/movieDetails")
//    public String movieDetails() {
//        return "movieDetails";
//    }

    @GetMapping("/movieDetails")
    public String getMovieList(Model model){
//        List<Movie> movies=movieService.fetchAll();
        Map<String, List<Movie>> allMovies = movieService.getMovieList();
//        model.addAttribute("movies", movies);
        model.addAttribute("movie", allMovies.get("nextChange").stream().map(movie ->
                Movie.builder()
                        .id(movie.getId())
                        .movieName(movie.getMovieName())
                        .movieDescription(movie.getMovieDescription())
                        .director(movie.getDirector())
                        .cast(movie.getCast())
                        .shows(movie.getShows())
                        .releaseDate(movie.getReleaseDate())
                        .duration(movie.getDuration())
                        .category(movie.getCategory())
                        .genre(movie.getGenre())
                        .shows(movie.getShows())
                        .imageBase64(movieServiceImpl.getImageBase64(movie.getImage()))
                        .image1Base64(movieServiceImpl.getImageBase64(movie.getImage1()))
                        .build()
        ));
        return "movieDetails";
    }

    @GetMapping("/movieList")
    public String getMovieList(Model model, Principal principal){
        model.addAttribute("userdata",userService.findByEmail(principal.getName()));
        return "/fragments/navbar";
    }
}