package com.developia.bookstrore.controller;

import com.developia.bookstrore.model.User;
import com.developia.bookstrore.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(path = "/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService=userService;
    }

    @PostMapping("/register")
    public String register(@ModelAttribute User user){
        userService.register(user);
        return "register";

    }

    @PostMapping("/login")
    public String login(Model model, @RequestParam ("username") String username,
                        @RequestParam ("password") String password){

        //User user = userService.login(username, password); //BAX

         return "redirect:/home";


    }
    @GetMapping("/logout")
    public String logout(){
        userService.logout();
        return "redirect:/home";
    }

}
