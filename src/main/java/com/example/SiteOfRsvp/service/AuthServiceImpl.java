package com.example.SiteOfRsvp.service;



import com.example.SiteOfRsvp.dto.UserDto;
import com.example.SiteOfRsvp.dto.UserResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@Transactional
public class AuthServiceImpl implements AuthService {



        private final UserService userService;

        public AuthServiceImpl(UserService userService) {
            this.userService = userService;
        }

        public Map<String, Object> login(UserDto userDto) {

            UserResponseDto userResponseDto =userService.credentialCheck(userDto.getEmail(), userDto.getPassword());


            return Map.of("message", "Login successful", "user", userResponseDto);
        }





}
