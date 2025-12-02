package com.ids2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable())         // desativa verificação CSRF
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll()     // libera TUDO
                )
                .formLogin(form -> form.disable())     // desativa tela de login
                .logout(logout -> logout.disable());   // desativa logout

        return http.build();
    }
}
