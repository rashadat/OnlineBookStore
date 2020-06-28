package com.developia.bookstrore.service;

import com.developia.bookstrore.model.Session;
import com.developia.bookstrore.model.User;

public interface SessionService {
        Session findActiveSession();

        void create(User user);

        void delete();




}
