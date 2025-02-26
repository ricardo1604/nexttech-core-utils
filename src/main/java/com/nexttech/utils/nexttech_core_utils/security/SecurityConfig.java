package com.nexttech.utils.nexttech_core_utils.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())  // 🔹 Deshabilitar CSRF (para APIs REST)
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/users/api/*", "/auth/api/*", "/v3/api-docs/**", "/swagger-ui/**").permitAll() // 🔹 Permitir sin autenticación
                .anyRequest().authenticated() // 🔹 Proteger todos los demás endpoints
            )
            .sessionManagement(session -> session.sessionCreationPolicy(STATELESS)); // 🔹 Sin estado (útil para JWT)

        return http.build();
    }
}
