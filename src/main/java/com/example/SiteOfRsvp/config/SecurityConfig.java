package com.example.SiteOfRsvp.config;

import com.example.SiteOfRsvp.service.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    private final CustomUserDetailsService userDetailsService;

    public SecurityConfig(CustomUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }



    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable) // API için CSRF disable
                .authorizeHttpRequests(auth -> auth
                                .requestMatchers("/order/register").permitAll()
                                .requestMatchers("/test").permitAll()
                                .requestMatchers("/me/**").permitAll()
                                .requestMatchers("/api/auth/login").permitAll()
                                .requestMatchers("/rsvp/**").permitAll()
                                // 🔐 ADMIN ONLY ENDPOINTS - Sadece ADMIN rolü
                                .requestMatchers("/orders").hasRole("ADMIN")
                                .requestMatchers("/admin/**").hasRole("ADMIN")  // password :Parola123

                                // 🔒 PROTECTED ENDPOINTS - Authenticated kullanıcılar
                                .requestMatchers("/order/**").authenticated()

                                // Diğer tüm endpoint'ler
                                .anyRequest().authenticated()
                        /*
                        .requestMatchers( "/event/**", "/event-fields/**", "/rsvp/**").permitAll() // Public endpoints
                        .requestMatchers( "/order/**").hasRole("CUSTOMER")
                         */
                )
                .userDetailsService(userDetailsService)
                .httpBasic(Customizer.withDefaults()) // BASIC AUTH aktif
                .formLogin(AbstractHttpConfigurer::disable); // Form login'i kapat (API için)

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }



}
