package com.developia.bookstrore.service.impl;

import com.developia.bookstrore.model.*;
import com.developia.bookstrore.repository.BookRepository;
import com.developia.bookstrore.repository.CartRepository;
import com.developia.bookstrore.repository.OrderRepository;
import com.developia.bookstrore.service.BookService;
import com.developia.bookstrore.service.CartService;
import com.developia.bookstrore.service.SessionService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class BookServiceImpl  implements BookService {

    private final BookRepository bookRepository;
    private final SessionService sessionService;




    public BookServiceImpl(BookRepository bookRepository, SessionService sessionService){
        this.bookRepository=bookRepository;
        this.sessionService = sessionService;

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
    public void review(String isbn, Review review) {

        if(review.getRating()== null || review.getComment()== null || review.getComment().isEmpty())
            return;

        if (review.getRating().compareTo(BigDecimal.valueOf(1))< 0 || review.getRating().compareTo(BigDecimal.valueOf(5)) > 0)
            return;

        Book book=findByIsbn(isbn);
        User user= sessionService.findActiveSession().getUser();


        review.setBook(book);
        review.setUser(user);



        List<Review> reviews =  book.getReviews();
        reviews.add(review);

        bookRepository.save(book);



    }




}
