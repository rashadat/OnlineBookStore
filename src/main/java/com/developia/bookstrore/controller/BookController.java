package com.developia.bookstrore.controller;

import com.developia.bookstrore.model.Book;
import com.developia.bookstrore.model.Card;
import com.developia.bookstrore.model.Review;
import com.developia.bookstrore.service.BookService;
import com.developia.bookstrore.service.CartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/book")
public class BookController {

    private final BookService bookService;
    private final CartService cartService;

    public BookController(BookService bookService, CartService cartService){
        this.bookService=bookService;
        this.cartService = cartService;
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
        model.addAttribute("review", new Review());
        return "bookView";

    }
    @PostMapping("/addToCart")
    public String addToCart(@RequestParam("isbn") String isbn){
        cartService.addBook(isbn);
        return "redirect:/home";
    }
    @PostMapping("/removeFromCart")
    public String removeFromCart(@RequestParam("isbn") String isbn){
        cartService.removeBook(isbn);
        return "redirect:/home";
    }

    @PostMapping("/review")
    public String review(@RequestParam("isbn") String isbn,@ModelAttribute Review review){
       bookService.review(isbn, review);
        return "redirect:/home";
    }

    @PostMapping("/checkout")
    public String checkout(@ModelAttribute Card card){
        cartService.checkout(card);
        return "redirect:/home";
    }
}
