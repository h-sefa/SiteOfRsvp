package com.example.SiteOfRsvp.dto;

import com.example.SiteOfRsvp.entity.Roles;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
public class UserResponseDto {

    // Getters and Setters
    private UUID id;
    private String email;
    private String fullName;
    private Roles role;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Constructors
    public UserResponseDto() {}

    public UserResponseDto(UUID id, String email, String fullName, Roles role,
                           LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.email = email;
        this.fullName = fullName;
        this.role = role;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

}
