package com.system.movieticketbooking.controller;

import com.system.movieticketbooking.entity.Booking;
import com.system.movieticketbooking.pojo.BookingPojo;
import com.system.movieticketbooking.services.BookingService;
import jakarta.validation.Valid;
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
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookingController {

    private final BookingService bookingService;


    @PostMapping("/save")
    public String saveBooking(@Valid BookingPojo bookingPojo, BindingResult bindingResult, RedirectAttributes redirectAttributes) throws IOException {

        Map<String, String> requestError = validateRequest(bindingResult);
        if (requestError != null) {
            redirectAttributes.addFlashAttribute("requestError", requestError);
            return "redirect:/home/homepage";
        }

        bookingService.saveBooking(bookingPojo);
        redirectAttributes.addFlashAttribute("successMsg", "User saved successfully");

        return "redirect:/pay/payment";
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

    @GetMapping("/bookingList")
    public String getBookingList(Model model, Principal principal){
        List<Booking> bookingLists=bookingService.fetchAll();
//        model.addAttribute("userdata", userService.findByEmail(principal.getName()));
        model.addAttribute("bookingLists", bookingLists);
        return "AllBookingLists";
    }


}