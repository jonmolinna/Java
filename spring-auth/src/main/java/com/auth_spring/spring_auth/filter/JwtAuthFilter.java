package com.auth_spring.spring_auth.filter;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.auth_spring.spring_auth.service.AuthService;
import com.auth_spring.spring_auth.service.JwtService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {
    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthService authService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        
                // Retrieve the Authorization header
                String authHeader = request.getHeader("Authorization");
                String token = null;
                String email = null;

                // Check if the header starts with "Bearer "
                if (authHeader != null && authHeader.startsWith("Bearer ")) {
                    token = authHeader.substring(7); // Extract token
                    email = jwtService.extractUsername(token); // Extract username from token
                }

                // If the token is valid and no authentication is set in the context
                if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                    UserDetails user = authService.loadUserByUsername(email);

                    // Validate token and set authentication
                    if (jwtService.validateToken(token, user)) {
                        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
                        authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                        SecurityContextHolder.getContext().setAuthentication(authToken);
                    }

                }

                // Continue the filter chain

                filterChain.doFilter(request, response);
    }

    
}
