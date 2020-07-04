package com.developia.bookstrore.service.impl;

import com.developia.bookstrore.model.Book;
import com.developia.bookstrore.repository.BookRepository;
import com.developia.bookstrore.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl  implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository){
        this.bookRepository=bookRepository;
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
}
