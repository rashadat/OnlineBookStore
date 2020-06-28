package com.developia.bookstrore.repository;

import com.developia.bookstrore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Long> {

    User findByUsername(String username);
}
