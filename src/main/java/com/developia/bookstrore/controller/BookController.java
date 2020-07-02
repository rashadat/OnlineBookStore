package com.developia.bookstrore.controller;

import com.developia.bookstrore.model.Book;
import com.developia.bookstrore.service.BookService;
import org.springframework.boot.autoconfigure.data.ConditionalOnRepositoryType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(path = "/book")
public class BookController {

    private final BookService bookService;
    public BookController(BookService bookService){
        this.bookService=bookService;
    }


    @PostMapping("/create")

    public String createBook(@ModelAttribute Book book){
        bookService.create(book);
        return "redirect:/home";
    }


}
