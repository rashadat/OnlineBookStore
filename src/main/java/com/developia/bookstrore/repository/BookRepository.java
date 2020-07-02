package com.developia.bookstrore.repository;

import com.developia.bookstrore.model.Book;
import com.developia.bookstrore.model.Session;
import com.developia.bookstrore.model.enums.SessionStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository <Book, Long> {

}
