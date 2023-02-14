package com.system.movieticketbooking.controller;

import com.system.movieticketbooking.entity.Movie;
import com.system.movieticketbooking.pojo.MoviePojo;
import com.system.movieticketbooking.services.MovieService;
import com.system.movieticketbooking.services.UserService;
import com.system.movieticketbooking.services.impl.MovieServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/movie")
public class MovieController {
    private final MovieService movieService;
    private final UserService userService;
    private final MovieServiceImpl movieServiceImpl;

    @GetMapping("/addMovie")
    public String addMovies(Model model){
        model.addAttribute("movie", new MoviePojo());
        return "addMovie";
    }



    @PostMapping("/saveMovie")
    public String saveMovie(MoviePojo moviePojo, BindingResult bindingResult, RedirectAttributes redirectAttributes) throws IOException {
        Map<String, String> requestError = validateRequest(bindingResult);
        if (requestError != null) {
            redirectAttributes.addFlashAttribute("requestError", requestError);
            return "redirect:/movie/addMovie";
        }

        movieService.saveMovie(moviePojo);
        redirectAttributes.addFlashAttribute("successMsg", "User saved successfully");


        return "redirect:/movie/movieList";

    }

    public Map<String, String> validateRequest(BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            return null;
        }
        Map<String, String> errors = new HashMap<>();
        bindingResult.getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            errors.put(fieldName, message);
        });
        return errors;

    }
    @GetMapping("/movieList")
    public String getNowShowing(Model model){
        Map<String, List<Movie>> allMovies = movieService.getMovieList();
        model.addAttribute("movie", allMovies.get("nowShowing").stream().map(movie ->
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
        model.addAttribute("movies", allMovies.get("nextChange").stream().map(movies ->
                Movie.builder()
                        .id(movies.getId())
                        .movieName(movies.getMovieName())
                        .movieDescription(movies.getMovieDescription())
                        .director(movies.getDirector())
                        .cast(movies.getCast())
                        .shows(movies.getShows())
                        .releaseDate(movies.getReleaseDate())
                        .duration(movies.getDuration())
                        .category(movies.getCategory())
                        .genre(movies.getGenre())
                        .shows(movies.getShows())
                        .imageBase64(movieServiceImpl.getImageBase64(movies.getImage()))
                        .image1Base64(movieServiceImpl.getImageBase64(movies.getImage1()))
                        .build()
        ));
        return "homepage";
    }
}
