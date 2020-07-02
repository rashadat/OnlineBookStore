package com.developia.bookstrore.service;

import com.developia.bookstrore.model.Book;

import java.util.List;

public interface BookService {
    void create (Book book);

    List<Book> findAll();

}
