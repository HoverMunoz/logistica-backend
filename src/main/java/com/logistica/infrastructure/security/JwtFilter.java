package com.logistica.infrastructure.security;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
public class JwtFilter extends OncePerRequestFilter {

    private final JwtService jwtService;

    public JwtFilter(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        final String authHeader = request.getHeader("Authorization");

        // 🔹 Si no hay header o no empieza con Bearer, continúa
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        try {

            // 🔹 Extraer token
            String token = authHeader.substring(7);

            // 🔹 Extraer username del token
            String username = jwtService.extractUsername(token);

            // 🔹 Si hay username y no hay autenticación previa
            if (username != null &&
                    SecurityContextHolder.getContext().getAuthentication() == null &&
                    jwtService.isTokenValid(token)) {

                // 🔹 Crear usuario con rol
                User userDetails = new User(
                        username,
                        "",
                        List.of(new SimpleGrantedAuthority("ROLE_USER"))
                );

                System.out.println("Username extracted: " + username);

                // 🔹 Crear autenticación
                UsernamePasswordAuthenticationToken authToken =
                        new UsernamePasswordAuthenticationToken(
                                userDetails,
                                null,
                                userDetails.getAuthorities()
                        );

                authToken.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request)
                );

                // 🔹 Guardar autenticación en contexto
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }

        } catch (Exception e) {
            // Si el token es inválido, expirado o mal formado
            SecurityContextHolder.clearContext();
        }

        System.out.println("Authorization header: " + authHeader);


        filterChain.doFilter(request, response);
    }
}