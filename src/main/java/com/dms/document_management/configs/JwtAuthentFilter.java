package com.dms.document_management.configs;

import com.dms.document_management.managers.UserInfoManager;
import com.dms.document_management.managers.implementation.configs.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Objects;


@Component
public class JwtAuthentFilter extends OncePerRequestFilter {
    @Autowired
    private JwtService jwtService;
    @Autowired
    private UserInfoManager userInfoManager;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // Extract the Authorization header from the incoming request
        String authHeader = request.getHeader("Authorization");

        // Initialize variables for token and username
        String token = null;
        String username = null;

        // Check if Authorization header is present and starts with "Bearer"
        if (Objects.nonNull(authHeader) && authHeader.startsWith("Bearer")) {
            // Extract the token from the Authorization header
            token = authHeader.substring(7);
            // Extract the username from the token using the JwtService
            username = jwtService.extractUsername(token);
        }

        // Check if username is present and user is not already authenticated
        if (Objects.nonNull(username) && Objects.isNull(SecurityContextHolder.getContext().getAuthentication())) {
            // Load UserDetails for the extracted username
            UserDetails userDetails = userInfoManager.loadUserByUsername(username);

            // Check if the token is valid for the UserDetails
            if (jwtService.isTokenValidated(token, userDetails)) {
                // Create UsernamePasswordAuthenticationToken with UserDetails and set it in the SecurityContextHolder
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }

        // Continue with the filter chain
        filterChain.doFilter(request, response);
    }
}
