package com.JV2.sistema.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable())                 // desativa proteção CSRF
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll()             // libera todas as rotas
                )
                .formLogin(login -> login.disable())           // desativa form de login
                .httpBasic(basic -> basic.disable());          // desativa login básico

        return http.build();
    }
}
