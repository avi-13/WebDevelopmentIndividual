package com.system.movieticketbooking.controller;

import com.system.movieticketbooking.services.MovieService;
import com.system.movieticketbooking.services.UserService;
import com.system.movieticketbooking.services.impl.MovieServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.Collection;

@Controller
@RequiredArgsConstructor
@RequestMapping("/home")
public class HomepageController {
    private final MovieService movieService;
    private final UserService userService;
    private final MovieServiceImpl movieServiceImpl;

    @GetMapping("/homepage")
    public String homePage(Authentication authentication) {

        if (authentication != null) {
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            for (GrantedAuthority grantedAuthority : authorities) {
                if (grantedAuthority.getAuthority().equals("Admin")) {
                    return "redirect:/admin/movieList";
                }
            }
        }
        return "redirect:/movie/movieList";
    }


    @GetMapping("/movieList")
    public String getMovieList(Model model, Principal principal) {
        model.addAttribute("userdata", userService.findByEmail(principal.getName()));
        return "/fragments/navbar";
    }
}