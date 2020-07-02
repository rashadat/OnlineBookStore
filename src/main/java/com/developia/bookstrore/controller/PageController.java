package com.developia.bookstrore.controller;

import com.developia.bookstrore.model.Book;
import com.developia.bookstrore.model.User;
import com.developia.bookstrore.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PageController {

    private final BookService bookService;

    public PageController(BookService bookService){
        this.bookService=bookService;
    }

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

    @GetMapping("/bookCreate")
    public String bookCreate(Model model){
        model.addAttribute("book", new Book());
        return "bookCreate";
    }
    @GetMapping("/books")
    public String books(Model model){
        List<Book> books =bookService.findAll();
        model.addAttribute("books",books);
        return "books";
    }



}
