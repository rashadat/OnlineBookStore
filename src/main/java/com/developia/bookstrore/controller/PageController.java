package com.developia.bookstrore.controller;

import com.developia.bookstrore.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PageController {

    @GetMapping (value = {"/" , "/home"})
    public String home() {
        return "home";
    }


    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("user", new User());
        return "register";

    }

    @GetMapping ("/login")
    public String login() {
        return "login";
    }

}
