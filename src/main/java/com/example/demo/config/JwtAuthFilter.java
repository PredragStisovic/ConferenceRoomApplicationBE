/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.config;

/**
 *
 * @author predrag
 */
import com.example.demo.domain.UlogaEnum;
import com.example.demo.dto.KorisnikDto;
import com.example.demo.service.KorisnikService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.security.core.authority.SimpleGrantedAuthority;



@Component
public class JwtAuthFilter extends OncePerRequestFilter {

    private final JWTConfig jwtConfig;
    private final KorisnikService korisnikService;

    @Autowired
    public JwtAuthFilter(JWTConfig jwtConfig, KorisnikService korisnikService) {
        this.jwtConfig = jwtConfig;
        this.korisnikService = korisnikService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");
        String token = null;
        int korisnikId = -1;
        

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            token = authHeader.substring(7);
            String tokenKorisnikId = jwtConfig.IzvuciIdIzJWTTokena(token);
            korisnikId = Integer.parseInt(tokenKorisnikId);
        }

        if (korisnikId != -1 && SecurityContextHolder.getContext().getAuthentication() == null) {
            KorisnikDto korisnik = korisnikService.findKorisnikById(korisnikId);
            UlogaEnum userRole = korisnik.getUloga();
            List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + userRole);
            authorities.add(authority);
            if (jwtConfig.validirajJWT(token)) {
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        korisnik,
                        null,
                        authorities);
                System.out.println(authToken);
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        filterChain.doFilter(request, response);
    }
}
