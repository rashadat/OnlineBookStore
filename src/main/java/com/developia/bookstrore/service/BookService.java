package com.developia.bookstrore.service;

import com.developia.bookstrore.model.Book;

import java.util.List;

public interface BookService {
    void create (Book book);

    void delete (String isbn);

    void update(Book book);

    Book find( String isbn);

    List<Book> findAll();


    Book findByIsbn(String isbn);
}
