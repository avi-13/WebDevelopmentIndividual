package com.system.movieticketbooking.controller;

import com.system.movieticketbooking.entity.User;
import com.system.movieticketbooking.pojo.UserPojo;
import com.system.movieticketbooking.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
//    private final ValidationAutoConfiguration validationAutoConfiguration;


    @GetMapping("/login")
    public String login() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        }
        return "redirect:/home/homepage";
    }

    @GetMapping("/list")
    public String getUserList(Model model) {
        List<User> users = userService.fetchAll();
        model.addAttribute("userList", users);
        return ("login");
    }

    @GetMapping("/create")
    public String createUser(Model model) {
        model.addAttribute("user",new UserPojo());
        return "signup";
    }

    @PostMapping("/save")
    public String saveUser(@Valid UserPojo userPojo) {
        userService.saveUser(userPojo);
        return "redirect:user/login";
    }

//    @GetMapping("/edit/{id}")
//    public String editUser(@PathVariable("id") Integer id, Model model){
//    User user = userService.fetchById(id);
//    model.addAttribute("user", new UserPojo(user));
//    return "login";
//    }

//    @GetMapping("/delete/{id}")
//    public String deleteuser(@PathVariable("id") Integer id){
//        userService.deleteById(id);
//        return "redirect:/user/list";
//    }

}