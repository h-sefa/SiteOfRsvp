package com.example.SiteOfRsvp.mappers;

import com.example.SiteOfRsvp.dto.UserDto;
import com.example.SiteOfRsvp.dto.UserResponseDto;
import com.example.SiteOfRsvp.entity.User;
import org.mapstruct.*;

import java.util.List;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface UserMapper {

    // Entity -> ResponseDTO
    @Mapping(target = "createdAt", source = "createdAt")
    @Mapping(target = "updatedAt", source = "updatedAt")
    UserResponseDto userToUserResponseDto(User user);


    @Mapping(target = "password", ignore = true) // Password service katmanında handle edilecek
    @Mapping(target = "role", ignore = true) // Default role service katmanında atanacak
    @Mapping(target = "orderList", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    User userDtoToUser(UserDto userDto);

    // Update mapping - sadece değişen alanları günceller
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "orderList", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void updateUserFromDto(UserDto userDto, @MappingTarget User user);

    // List dönüşümleri
    List<UserResponseDto> usersToUserResponseDtos(List<User> users);
}