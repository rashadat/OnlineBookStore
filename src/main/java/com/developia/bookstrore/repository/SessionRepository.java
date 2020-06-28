package com.developia.bookstrore.repository;

import com.developia.bookstrore.model.Session;
import com.developia.bookstrore.model.User;
import com.developia.bookstrore.model.enums.SessionStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository <Session, Long> {
    Session findByStatus(SessionStatus status);
}
