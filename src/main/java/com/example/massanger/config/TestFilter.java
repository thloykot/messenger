package com.example.massanger.config;

import com.example.massanger.service.RedisService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class TestFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        if (request.getMethod().equals("GET") ||
                request.getRequestURI().equals("/registration") ||
                isAuthorized(request)) {

            filterChain.doFilter(request, response);
        }


    }

    private boolean isAuthorized(HttpServletRequest request) {
        return request.getHeader("Token") != null;
    }
}
