/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.config;

import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

/**
 *
 * @author predrag
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
           .csrf(csrf -> csrf.disable())
           .cors(cors->cors.configurationSource(
                new CorsConfigurationSource() {
                    @Override
                    public CorsConfiguration getCorsConfiguration(
                            HttpServletRequest request) {
                        CorsConfiguration cors = new CorsConfiguration();
                        cors.addAllowedOriginPattern("*");
                        cors.setAllowedHeaders(List.of("*"));
                        cors.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE","PATCH"));
                        cors.setAllowCredentials(true);
                        cors.setMaxAge(3600L);
                        return cors;
                    }
                }
            ))
            .authorizeHttpRequests(authorizeRequests ->
                authorizeRequests
                    .requestMatchers("/public/**", "/api/open/**", "/", "/auth/**").permitAll()
                    .requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll()
                    .requestMatchers("/css/**", "/js/**", "/images/**").permitAll()
                    .anyRequest().authenticated()
            )
            .logout(logout ->
                logout
                    .permitAll()
            );    

        return http.build();
    }
}


