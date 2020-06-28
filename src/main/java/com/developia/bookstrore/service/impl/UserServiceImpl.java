package com.developia.bookstrore.service.impl;

import com.developia.bookstrore.exception.AccessDeniedException;
import com.developia.bookstrore.exception.NotFoundException;
import com.developia.bookstrore.model.Session;
import com.developia.bookstrore.model.User;
import com.developia.bookstrore.model.enums.Role;
import com.developia.bookstrore.model.enums.SessionStatus;
import com.developia.bookstrore.repository.UserRepository;
import com.developia.bookstrore.service.SessionService;
import com.developia.bookstrore.service.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final SessionService sessionService;

    public UserServiceImpl(UserRepository userRepository, SessionService sessionService){

        this.userRepository = userRepository;
        this.sessionService= sessionService;
    }

    @Override
    public void register(User user) {

        if(!user.getPassword().equals(user.getConfirmPassword()))
            throw new IllegalArgumentException("Password mismatch");

        user.setRole(Role.USER);
        user.setPassword(encode(user.getPassword()));
        user.setConfirmPassword(encode(user.getPassword()));


        userRepository.save(user);

    }

    @Override
    public User login(String username, String password) {

        User user;

        try {
            user = userRepository.findByUsername(username);
        }catch (Exception e){

            throw new NotFoundException(username + " NOT FOUND");

        }
        if(!user.getPassword().equals(password))
            throw new AccessDeniedException("INCORRECT PASSWORD");

            sessionService.create(user);

        return user;
    }

    @Override
    public void logout() {
sessionService.delete();

    }

    private String encode(String password){
        return "encoded password";

    }


}
