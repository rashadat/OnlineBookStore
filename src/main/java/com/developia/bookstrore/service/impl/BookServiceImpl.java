package com.developia.bookstrore.service.impl;

import com.developia.bookstrore.model.Book;
import com.developia.bookstrore.model.Cart;
import com.developia.bookstrore.model.Session;
import com.developia.bookstrore.model.User;
import com.developia.bookstrore.repository.BookRepository;
import com.developia.bookstrore.repository.CartRepository;
import com.developia.bookstrore.service.BookService;
import com.developia.bookstrore.service.SessionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl  implements BookService {

    private final BookRepository bookRepository;
    private final SessionService sessionService;
    private final CartRepository cartRepository;

    public BookServiceImpl(BookRepository bookRepository, SessionService sessionService, CartRepository cartRepository){
        this.bookRepository=bookRepository;
        this.sessionService = sessionService;
        this.cartRepository = cartRepository;
    }

    @Override
    public void create(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void delete(String isbn) {
        Book book = bookRepository.findByIsbn(isbn);
        bookRepository.delete(book);

    }

    @Override
    public void update(Book book) {
        Book oldBook = bookRepository.findByIsbn(book.getIsbn());
        oldBook.setAuthor(book.getAuthor());
        oldBook.setName(book.getName());
        oldBook.setPrice(book.getPrice());
        oldBook.setPageSize(book.getPageSize());
        oldBook.setPublishDate(book.getPublishDate());
        oldBook.setDescription(book.getDescription());
        bookRepository.save(oldBook);

    }

    @Override
    public Book find(String isbn) {
        return bookRepository.findByIsbn(isbn);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn);
    }

    @Override
    public void addToCart(String isbn) {
        Session session=sessionService.findActiveSession();
        if(session==null) return;
        User user = session.getUser();
        Cart cart = cartRepository.findByUser(user);

        if(cart== null) {
            cart = new Cart();
            cart.setUser(user);
        }

        Book book= findByIsbn(isbn);
        List<Book> booksInCart=cart.getBooks();
        booksInCart.add(book);

        cartRepository.save(cart);
    }
}
