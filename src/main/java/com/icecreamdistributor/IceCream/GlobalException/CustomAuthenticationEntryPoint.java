package com.icecreamdistributor.IceCream.GlobalException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.icecreamdistributor.IceCream.GlobalException.type.ApiError;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;

/**
 * This class handles all AuthenticationExceptions.
 * It's triggered by the Spring Security filter chain when a user
 * tries to access a secured endpoint without being authenticated
 * or when a login fails (e.g., BadCredentialsException).
 */
@Component
@RequiredArgsConstructor
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    // We inject Spring's pre-configured ObjectMapper
    private final ObjectMapper objectMapper;
    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {

        // By default, Spring Security returns "Bad credentials" for both
        // wrong username and wrong password. This is a secure practice.
        // We will return a 401 Unauthorized.
        ApiError apiError = new ApiError(
                LocalDateTime.now(),
                HttpStatus.UNAUTHORIZED.value(), // 401
                "Invalid username or password", // Generic, secure message
                request.getRequestURI()
        );

        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);

        // Write the ApiError as JSON to the response
        objectMapper.writeValue(response.getOutputStream(), apiError);
    }
}
