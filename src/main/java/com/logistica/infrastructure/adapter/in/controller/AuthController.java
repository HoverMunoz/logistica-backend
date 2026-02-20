package com.logistica.infrastructure.adapter.in.controller;

import org.springframework.web.bind.annotation.*;
import com.logistica.infrastructure.security.JwtService;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final JwtService jwtService;

    public AuthController(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> request) {

        String username = request.get("username");
        String password = request.get("password");

        // Simulación simple
        if ("admin".equals(username) && "1234".equals(password)) {
            String token = jwtService.generateToken(username);
            return Map.of("token", token);
        }

        throw new RuntimeException("Credenciales inválidas");
    }
}
