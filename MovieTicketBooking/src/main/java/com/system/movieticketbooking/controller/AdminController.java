package com.system.movieticketbooking.controller;

import com.system.movieticketbooking.entity.Contact;
import com.system.movieticketbooking.entity.Movie;
import com.system.movieticketbooking.pojo.MoviePojo;
import com.system.movieticketbooking.services.ContactService;
import com.system.movieticketbooking.services.MovieService;
import com.system.movieticketbooking.services.UserService;
import com.system.movieticketbooking.services.impl.MovieServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private final MovieServiceImpl movieServiceImpl;
    private final MovieService movieService;
    private final ContactService contactService;
    private final UserService userService;

    @GetMapping("/movieList")
    public String getMoviesList(Model model) {
        List<Movie> adminMovies = movieService.fetchAll();
        model.addAttribute("adMovies", adminMovies.stream().map(adMovies ->
                Movie.builder()
                        .id(adMovies.getId())
                        .movieName(adMovies.getMovieName())
                        .movieDescription(adMovies.getMovieDescription())
                        .director(adMovies.getDirector())
                        .cast(adMovies.getCast())
                        .shows(adMovies.getShows())
                        .releaseDate(adMovies.getReleaseDate())
                        .duration(adMovies.getDuration())
                        .cubes(adMovies.getCubes())
                        .genre(adMovies.getGenre())
                        .shows(adMovies.getShows())
                        .imageBase64(movieServiceImpl.getImageBase64(adMovies.getImage()))
                        .image1Base64(movieServiceImpl.getImageBase64(adMovies.getImage1()))
                        .build()
        ));
        return "adminMovieList";
    }

    @GetMapping("/getMovie/{id}")
    public String fetchById(@PathVariable Integer id, Model model, Principal principal) {
        Movie movie = movieService.fetchById(id);
        model.addAttribute("userdata", userService.findByEmail(principal.getName()));
        model.addAttribute("fetchMovies", new MoviePojo(movie));
//        model.addAttribute("productData", productService.fetchById(principal.getName());
        model.addAttribute("fetchMovie", movie);
        return "editMovie";
    }

    @GetMapping("/edit/{id}")
    public String editProduct(@PathVariable("id") Integer id, Model model) {
        Movie movie = movieService.fetchById(id);
        model.addAttribute("editMovie", new MoviePojo(movie));
        return "redirect:/admin/movieList";
    }

    @GetMapping("delete/{id}")
    public String deleteMovie(@PathVariable("id") Integer id) {
        movieService.deleteById(id);
        return "redirect:/admin/movieList";
    }

    @GetMapping("/feedback")
    public String feedbackPage(Model model){
        List <Contact> contact = contactService.fetchAll();
        model.addAttribute("contacts" , contact);
        return "UserFeedback";
    }

}