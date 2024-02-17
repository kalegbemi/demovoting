package com.example.demovoting.security.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

    private static final String SECRET_KEY = "4vMnwad+ROEFDJRjSVkYwuheHQHpWf8yo8CVYqquBxdYoPAV9QwW5FnK271G2Fq2tFccYSFzPYJxrotQRmyB/lCcTwZotPFcG+a21tKKqEvSKakhKuzzHgyy1VY0FWOw4tVl5EF+SgOY25zHjmsxCDzGVKMweDKMzrEuTODN7at6weAVQwQ9R6S+hLBnQCZlB0R0pnmKU/9UXuarD/bz+UhxELAHuhjmsMsopFfDeEAGBS2KmOnzUwJShdYCdH3i+3gQY/6msBMcyCe8GpMLo19MEegIPWhpj3Fjqh3CqNH6iiShGLKS+6ITL9VZXt/RRK/FvFSNaeOYUlbcDwth72Y2BXlK3Y37E7HepQy3oa0=";

    public String extractUsername(String token) {
        return extractClaims(token, Claims::getSubject);

    }

    public <T> T extractClaims(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public String generateToken(UserDetails userDetails) {
        return generateToken(new HashMap<>(), userDetails);
    }

    private String generateToken(Map<String, Object> extraClaims, UserDetails userDetails) {
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + (1000 * 60 * 10)))
                .signWith(getSignKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean isTokenValid(String token, UserDetails userDetails){
       final String username = extractUsername(token);
       return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return (extractClaims(token, Claims::getExpiration));
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSignKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

}
