package com.developia.bookstrore.service;


import com.developia.bookstrore.model.Book;
import com.developia.bookstrore.model.Card;
import com.developia.bookstrore.model.Cart;

import java.util.List;

public interface CartService {
   Cart findActiveCart();

   void addBook(String isbn);
   void removeBook(String isbn);
   void checkout(Card card);
}
