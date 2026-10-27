package com.Ecommerce.EcommerceBackend.SpringSecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
@EnableWebSecurity
public class SecurityConfig {
@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers("/Products/**").hasAuthority("admin")
                        .requestMatchers("/category").authenticated()
                        .anyRequest().authenticated()
                )
             .oauth2ResourceServer((oauth2) -> oauth2.jwt(Customizer.withDefaults())).
                oauth2ResourceServer(oauth2->oauth2
                        .jwt(jwt->jwt.jwtAuthenticationConverter(new CustomJwtAuthenticationConverter())));
        return http.build();
    }
}
