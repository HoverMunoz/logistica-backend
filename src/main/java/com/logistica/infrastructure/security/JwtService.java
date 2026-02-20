package com.logistica.infrastructure.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class JwtService {

    // 🔐 Usa mínimo 256 bits (32 caracteres)
    private static final String SECRET_KEY =
            "mysecretkeymysecretkeymysecretkey12";

    // 🔹 Extraer username
    public String extractUsername(String token) {
        return extractAllClaims(token).getSubject();
    }

    // 🔹 Validar token
    public boolean isTokenValid(String token) {
        try {
            return !isTokenExpired(token);
        } catch (Exception e) {
            return false;
        }
    }

    // 🔹 Verificar expiración
    private boolean isTokenExpired(String token) {
        return extractAllClaims(token)
                .getExpiration()
                .before(new Date());
    }

    // 🔹 Extraer todos los claims
    private Claims extractAllClaims(String token) {

        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    // 🔹 Generar token
    public String generateToken(String username) {

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 hora
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    // 🔹 Obtener clave
    private Key getSignInKey() {

        byte[] keyBytes = Decoders.BASE64.decode(
                java.util.Base64.getEncoder()
                        .encodeToString(SECRET_KEY.getBytes())
        );

        return Keys.hmacShaKeyFor(keyBytes);
    }
}
