package com.developia.bookstrore.controller;

import com.developia.bookstrore.model.Book;
import com.developia.bookstrore.model.Cart;
import com.developia.bookstrore.model.User;
import com.developia.bookstrore.service.BookService;
import com.developia.bookstrore.service.CartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PageController {

    private final BookService bookService;
    private final CartService cartService;


    public PageController(BookService bookService, CartService cartService){
        this.bookService=bookService;
        this.cartService = cartService;
    }

    @GetMapping (value = {"/" , "/home"})
    public String home(Model model) {
        List<Book> books = bookService.findAll();
        model.addAttribute("books", books);
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

    @GetMapping("/bookPage")
    public String bookPage(){
        return "bookPage";
    }

    @GetMapping("/books")
    public String books(Model model){
        List<Book> books =bookService.findAll();
        model.addAttribute("books",books);
        return "books";
    }



    @GetMapping(value = "/bookUpdate")
    public String bookUpdate(Model model) {
        model.addAttribute("book", new Book());
        return "bookUpdate";
    }

    @GetMapping("/cartPage")
    public String cartPage(Model model){
        model.addAttribute("book", new Book());
        Cart cart=cartService.findActiveCart();
        model.addAttribute("cart",cart);
        return "cartPage";
    }









}
