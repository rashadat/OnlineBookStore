package com.developia.bookstrore.config;

import com.developia.bookstrore.model.Session;
import com.developia.bookstrore.model.enums.Role;
import com.developia.bookstrore.service.SessionService;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
public class RequestFilter implements Filter {

    private final SessionService sessionService;

    public RequestFilter( SessionService sessionService){
        this.sessionService=sessionService;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        Session session= sessionService.findActiveSession();
        if(session==null)
            res.addHeader("role", Role.USER.name());
        else res.addHeader("role", session.getUser().getRole().name());

        filterChain.doFilter(req, res);


    }


}
