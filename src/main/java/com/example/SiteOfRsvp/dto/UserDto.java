package com.example.SiteOfRsvp.dto;

import com.example.SiteOfRsvp.entity.Roles;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserDto {

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Full name is mandatory")
    private String fullName;

    @NotBlank(message = "Password is mandatory")
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;
    //role silindi




     public UserDto() {
    }

    public UserDto(String email, String fullName, String password) {
        this.email = email;
        this.fullName = fullName;
        this.password = password;
        //role silindi
    }

    //Getter and Setter

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    //role get silindi

    //role set silindi

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //Getter and Setter
}
