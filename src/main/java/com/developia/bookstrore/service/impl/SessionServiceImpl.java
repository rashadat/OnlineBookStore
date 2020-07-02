package com.developia.bookstrore.service.impl;

import com.developia.bookstrore.exception.AccessDeniedException;
import com.developia.bookstrore.exception.NotFoundException;
import com.developia.bookstrore.model.Session;
import com.developia.bookstrore.model.User;
import com.developia.bookstrore.model.enums.Role;
import com.developia.bookstrore.model.enums.SessionStatus;
import com.developia.bookstrore.repository.SessionRepository;
import com.developia.bookstrore.repository.UserRepository;
import com.developia.bookstrore.service.SessionService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class SessionServiceImpl implements SessionService {

    private final SessionRepository sessionRepository;

    public SessionServiceImpl(SessionRepository sessionRepository){
        this.sessionRepository = sessionRepository;
    }


    @Override
    public Session findActiveSession() {
        return sessionRepository.findByStatus(SessionStatus.ACTIVE);
    }

    @Override
    public void create(User user) {
        Session session = Session
                .builder()
                .sessionId(UUID.randomUUID().toString())
                .user(user)
                .startTime(LocalDateTime.now())
                .status(SessionStatus.ACTIVE)
                .build();
        sessionRepository.save(session);

    }

    @Override
    public void delete() {

        Session session=findActiveSession();
        if(session == null) return;
        session.setEndTime(LocalDateTime.now());
        session.setStatus(SessionStatus.EXPIRED);
        sessionRepository.save(session);
    }

}
