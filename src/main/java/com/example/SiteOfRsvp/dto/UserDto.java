package com.example.SiteOfRsvp.dto;

import com.example.SiteOfRsvp.entity.Roles;

public class UserDto {

    private String email;
    private String fullName;
    private String password;
    private Roles role;

    public UserDto() {
    }

    public UserDto(String email, String fullName, String password, Roles role) {
        this.email = email;
        this.fullName = fullName;
        this.password = password;
        this.role = role;
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

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //Getter and Setter
}
