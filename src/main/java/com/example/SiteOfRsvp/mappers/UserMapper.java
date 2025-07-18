package com.example.SiteOfRsvp.mappers;

import com.example.SiteOfRsvp.dto.UserDto;
import com.example.SiteOfRsvp.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toDto(User user);

    User toEntity(UserDto userDto);
}
