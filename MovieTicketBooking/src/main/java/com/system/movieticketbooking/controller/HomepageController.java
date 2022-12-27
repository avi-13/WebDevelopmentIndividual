package com.system.movieticketbooking.controller;

import com.system.movieticketbooking.services.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
@RequiredArgsConstructor
@RequestMapping("/home")
public class HomepageController {
    private final ContactService contactService;

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

}