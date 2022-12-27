package com.system.movieticketbooking.controller;

import com.system.movieticketbooking.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
@RequestMapping("/pay")
public class PaymentController {

    private final UserService userService;

    @GetMapping("/payment")
    public String pay( Model model, Principal principal) {
            model.addAttribute("userdata", userService.findByEmail(principal.getName()));
        return "Payment";
    }


}
