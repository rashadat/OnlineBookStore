package com.developia.bookstrore.controller;

import com.developia.bookstrore.model.Book;
import com.developia.bookstrore.service.BookService;
import org.springframework.boot.autoconfigure.data.ConditionalOnRepositoryType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/book")
public class BookController {

    private final BookService bookService;
    public BookController(BookService bookService){
        this.bookService=bookService;
    }

    @PostMapping("/findByIsbn")
    public String findByIsbn(Model model, @RequestParam("isbn") String isbn){
        Book book = bookService.findByIsbn(isbn);
        model.addAttribute("book", book);
        return "bookDelete";
    }

    @GetMapping("/find")
    public String find(Model model, @RequestParam String isbn) {
        Book book = bookService.find(isbn);
        model.addAttribute("book", book);
        return "bookUpdate";
    }

    @PostMapping("/create")
    public String createBook(@ModelAttribute Book book){
        bookService.create(book);
        return "redirect:/home";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("isbn") String isbn) {
        bookService.delete(isbn);
        return "bookDelete";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute Book book) {
        bookService.update(book);
        return "home";
    }


}
