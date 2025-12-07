package com.example.SiteOfRsvp.service;

import com.example.SiteOfRsvp.dto.UserDto;
import com.example.SiteOfRsvp.dto.UserResponseDto;
import com.example.SiteOfRsvp.entity.User;

import java.util.List;
import java.util.UUID;

public interface UserService {
    UserResponseDto registerUser(UserDto userDto);
    User registerUserforOrderService(UserDto userDto);
    UserResponseDto findByEmail(String email);
    UserResponseDto findById(UUID id);
    List<UserResponseDto> findAllUsers();
    UserResponseDto updateUser(UUID id, UserDto userDto);
    void deleteUser(UUID id);
    UserResponseDto credentialCheck(String email, String password);
    boolean existsByEmail(String email);
}