package com.system.movieticketbooking.controller;

import com.system.movieticketbooking.pojo.BookingPojo;
import com.system.movieticketbooking.pojo.UserPojo;
import com.system.movieticketbooking.services.BookingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookingController {

    private final BookingService bookingService;

    @GetMapping("/bookingPage")
    public String showBookingPage(Model model) {
        model.addAttribute("book", new UserPojo());
        return "BookingPage";
    }

    @PostMapping("/saveBooking")
    public String saveBooking(@Valid BookingPojo bookingPojo) throws IOException {
        bookingService.saveBooking(bookingPojo);
        return "redirect:/home/homePage";
    }

}