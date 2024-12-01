package com.panic.sasserver.service;

import java.util.Date;

import javax.crypto.SecretKey;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtService {
    @Value("${security.jwt.token.secret-key:secret-key}")
    private String secretKey ;

    public String generateToken(String email) {
        JwtBuilder jwt = Jwts.builder()
                .subject(email)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24)) // 1 day
                .signWith(generateJwtSecretKey(), Jwts.SIG.HS256);
        return jwt.compact();
    }

    public SecretKey generateJwtSecretKey() {

        byte[] keyBytes = secretKey.getBytes();

        byte[] keyBytesPadded = new byte[32];
        System.arraycopy(keyBytes, 0, keyBytesPadded, 0, Math.min(keyBytes.length, 32));

        return Keys.hmacShaKeyFor(keyBytesPadded);
    }
    public boolean validateToken(String token, String email) {
        return (email.equals(getEmail(token)) && !isTokenExpired(token) );
    }

    private boolean isTokenExpired(String token) {
        return getClaims(token).getExpiration().before(new Date());
    }

    private String getEmail(String token) {
        return getClaims(token).getSubject();
    }

    public String extractEmail(String token) {
        return getClaims(token).getSubject();
    }

    public Claims getClaims(String token) {
        return Jwts.parser().verifyWith(generateJwtSecretKey()).build().parseSignedClaims(token).getPayload();
    }
}
