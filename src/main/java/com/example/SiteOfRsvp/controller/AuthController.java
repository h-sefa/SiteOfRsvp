package com.example.SiteOfRsvp.controller;

import com.example.SiteOfRsvp.dto.LoginRequest;
import com.example.SiteOfRsvp.dto.UserDto;
import com.example.SiteOfRsvp.dto.UserResponseDto;
import com.example.SiteOfRsvp.entity.User;
import com.example.SiteOfRsvp.repository.UserRepository;
import com.example.SiteOfRsvp.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;

    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDto userDto) {

        Map<String, Object>  successLogin = authService.login(userDto);


        return ResponseEntity.ok(Map.of(
                "message", "Login successful",
                "userId", successLogin.get("user")

        ));
    }
}

