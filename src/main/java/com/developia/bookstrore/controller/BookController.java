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
        return "bookUpdate";
    }

    @GetMapping("/find")
    public String find(Model model, @RequestParam String isbn) {
        Book book = bookService.find(isbn);
        model.addAttribute("book", book);
        return "bookUpdate";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Book book){
        bookService.create(book);
        return "redirect:/home";
    }

    @PostMapping(value = "/update", params = "action=Update")
    public String update(@ModelAttribute Book book) {
        bookService.update(book);
        return "redirect:/home";
    }

    @PostMapping(value = "/update", params = "action=Delete")
    public String delete(@ModelAttribute Book book) {
        bookService.delete(book.getIsbn());
        return "redirect:/home";
    }

    @GetMapping(value = "/view")
    public String view(Model model, @RequestParam ("isbn") String isbn) {
        Book book = bookService.findByIsbn(isbn);
        model.addAttribute("book", book);
        return "bookView";

    }
    @PostMapping("/addToCart")
    public String create(@RequestParam("isbn") String isbn){
        bookService.addToCart(isbn);
        return "redirect:/home";
    }
}
