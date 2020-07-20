package com.developia.bookstrore.repository;

import com.developia.bookstrore.model.Book;
import com.developia.bookstrore.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository <Order, Long> {


}
