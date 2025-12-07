package com.example.SiteOfRsvp.service;


import com.example.SiteOfRsvp.dto.UserDto;

import java.util.Map;

public interface AuthService {

    Map<String, Object> login(UserDto userDto);
}
