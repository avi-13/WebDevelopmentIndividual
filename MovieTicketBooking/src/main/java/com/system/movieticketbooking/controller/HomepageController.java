package com.system.movieticketbooking.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping()
public class HomepageController {

    @GetMapping("/homepage")
    public String homePage() {
        return "HomePage";
    }


}