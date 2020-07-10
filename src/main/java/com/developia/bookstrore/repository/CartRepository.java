package com.developia.bookstrore.repository;

import com.developia.bookstrore.model.Book;
import com.developia.bookstrore.model.Cart;
import com.developia.bookstrore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {

    Cart findByUser(User user);
}
