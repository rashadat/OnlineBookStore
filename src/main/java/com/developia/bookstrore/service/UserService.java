package com.developia.bookstrore.service;

import com.developia.bookstrore.model.User;

public interface UserService {
    void register(User user);

    User login(String username, String password);
    void logout();

}
