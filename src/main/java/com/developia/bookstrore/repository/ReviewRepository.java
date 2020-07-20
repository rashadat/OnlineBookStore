package com.developia.bookstrore.repository;

import com.developia.bookstrore.model.Book;
import com.developia.bookstrore.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository <Review, Long> {


}
