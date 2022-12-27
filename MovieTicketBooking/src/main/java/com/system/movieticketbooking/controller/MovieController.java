package com.system.movieticketbooking.controller;

import com.system.movieticketbooking.entity.Movie;
import com.system.movieticketbooking.pojo.BookingPojo;
import com.system.movieticketbooking.pojo.MoviePojo;
import com.system.movieticketbooking.services.BookingService;
import com.system.movieticketbooking.services.MovieService;
import com.system.movieticketbooking.services.UserService;
import com.system.movieticketbooking.services.impl.MovieServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/movie")
public class MovieController {
    private final MovieService movieService;
    private final BookingService bookingService;
    private final UserService userService;
    private final MovieServiceImpl movieServiceImpl;

    @GetMapping("/addMovie")
    public String addMovies(Model model) {
        model.addAttribute("movie", new MoviePojo());
        return "addMovie";
    }


    @PostMapping("/saveMovie")
    public String saveMovie(@Valid MoviePojo moviePojo, BindingResult bindingResult, RedirectAttributes redirectAttributes) throws IOException {
        Map<String, String> requestError = validateRequest(bindingResult);
        if (requestError != null) {
            redirectAttributes.addFlashAttribute("requestError", requestError);
            return "redirect:/home/homepage";
        }

        movieService.saveMovie(moviePojo);
        redirectAttributes.addFlashAttribute("successMsg", "User saved successfully");


        return "redirect:/admin/movieList";

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
    public String getHomePage(Model model, Principal principal) {
        if (principal != null) {
            model.addAttribute("userdata", userService.findByEmail(principal.getName()));
        }
        List <Movie> allMovie=movieService.fetchAll();

        Map<String, List<Movie>> allMovies = movieService.getMovieList();

        model.addAttribute("imageBanner", allMovie.stream().map(movies ->
                        Movie.builder()
                                .id(movies.getId())
                                .image1Base64(movieServiceImpl.getImageBase64(movies.getImage1()))
                                .build()));

        model.addAttribute("movie", allMovies.get("nowShowing").stream().map(movie ->
                Movie.builder()
                        .id(movie.getId())
                        .imageBase64(movieServiceImpl.getImageBase64(movie.getImage()))
                        .image1Base64(movieServiceImpl.getImageBase64(movie.getImage1()))
                        .build()
        ));
        model.addAttribute("nextChange", allMovies.get("nextChange").stream().map(nextChange ->
                Movie.builder()
                        .id(nextChange.getId())
                        .imageBase64(movieServiceImpl.getImageBase64(nextChange.getImage()))
                        .image1Base64(movieServiceImpl.getImageBase64(nextChange.getImage1()))
                        .build()
        ));
        model.addAttribute("comingSoon", allMovies.get("comingSoon").stream().map(comingSoon ->
                Movie.builder()
                        .id(comingSoon.getId())
                        .imageBase64(movieServiceImpl.getImageBase64(comingSoon.getImage()))
                        .image1Base64(movieServiceImpl.getImageBase64(comingSoon.getImage1()))
                        .build()
        ));
        return "homepage";
    }

    @GetMapping("/{id}")
    public String fetchById(@PathVariable Integer id, Model model, Principal principal) {
        Movie movie = movieService.fetchById(id);
        if (principal != null) {
            model.addAttribute("userdata", userService.findByEmail(principal.getName()));
        }
        model.addAttribute("movie", new MoviePojo(movie));
        model.addAttribute("mov", movie);
        model.addAttribute("saveBooking",new BookingPojo());
        return "movieDetails";
    }

    @GetMapping("/book/{id}")
    public String bookingPage(@PathVariable Integer id, Model model, Principal principal) {
        Movie movie = movieService.fetchById(id);
        if (principal != null) {
            model.addAttribute("userdata", userService.findByEmail(principal.getName()));
        }
        model.addAttribute("movie", new MoviePojo(movie));
        model.addAttribute("mov", movie);
        model.addAttribute("saveBooking",new BookingPojo());
        return "BookingPage";
    }


}
