package com.system.movieticketbooking.controller;

import com.system.movieticketbooking.entity.Booking;
import com.system.movieticketbooking.entity.User;
import com.system.movieticketbooking.pojo.ContactPojo;
import com.system.movieticketbooking.pojo.UserPojo;
import com.system.movieticketbooking.repo.BookingRepo;
import com.system.movieticketbooking.services.BookingService;
import com.system.movieticketbooking.services.ContactService;
import com.system.movieticketbooking.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    private final ContactService contactService;
    private final BookingRepo bookingRepo;
    private final BookingService bookingService;

//    private final ValidationAutoConfiguration validationAutoConfiguration;


//    @GetMapping("/login")
//    public String login() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
//            return "login";
//        }
//        return "redirect:/home/homepage";
//    }
//
//    @GetMapping("/list")
//    public String getUserList(Model model) {
//        List<User> users = userService.fetchAll();
//        model.addAttribute("userList", users);
//        return ("login");
//    }

    @GetMapping("/create")
    public String createUser(Model model) {
        model.addAttribute("user", new UserPojo());
        return "signup";
    }

    @PostMapping("/save")
    public String saveUser(@Valid UserPojo userPojo) {
        userService.saveUser(userPojo);
        return "redirect:/login";
    }

    @GetMapping("/profile/{id}")
    public String getUserProfile(@PathVariable("id") Integer id, Model model, Principal principal) {
        User user = userService.fetchById(id);
        model.addAttribute("userdata", userService.findByEmail(principal.getName()));
        model.addAttribute("users", new UserPojo(user));
        model.addAttribute("currentUser", user);
        return "userProfile";
    }

    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable("id") Integer id, Model model, Principal principal) {
        User user = userService.fetchById(id);
        model.addAttribute("userdata", userService.findByEmail(principal.getName()));
        model.addAttribute("currentUser", new UserPojo(user));
        return "redirect:/user/profile/{id}";
    }

    @GetMapping("/delete/{id}")
    public String deleteUserId(@PathVariable("id") Integer id) {
        userService.deleteById(id);
        return "redirect:/login";
    }


    @GetMapping("/forgotpassword")
    public String forgotpassword(Model model) {
        model.addAttribute("users", new UserPojo());
        return ("Forgetpasword");
    }

    @PostMapping("/changepassword")
    public String changepassword(@RequestParam("email") String email, Model model, @Valid UserPojo userPojo) {
        userService.processPasswordResetRequest(userPojo.getEmail());
        model.addAttribute("message", "Your new password has been sent to your email Please " +
                "check your inbox");
        return "redirect:/login";
    }


    @GetMapping("/contactus")
    public String contact(Model model) {
        model.addAttribute("contact", new ContactPojo());
        return "ContactUs";
    }


    @PostMapping("/savecontact")
    public String save(@Valid ContactPojo contactPojo) {
        contactService.save(contactPojo);
        return "redirect:/home/homepage";
    }

    @GetMapping("/booked/{id}")
    public String fetchAllbook(@PathVariable("id") Integer id, Model model , Principal principal){
        List<Booking> order= bookingService.findBookingById(id);
        model.addAttribute("booking",order);
        model.addAttribute("userdata",userService.findByEmail(principal.getName()));

        return "My Tickets";
    }

    @GetMapping("/aboutUs")
    public String aboutUs( Model model, Principal principal) {
        if (principal != null) {
            model.addAttribute("userdata", userService.findByEmail(principal.getName()));
        }
        return "aboutUs";
    }

}