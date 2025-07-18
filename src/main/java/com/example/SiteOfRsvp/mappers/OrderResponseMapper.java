package com.example.SiteOfRsvp.mappers;

import com.example.SiteOfRsvp.dto.OrderResponseDto;
import com.example.SiteOfRsvp.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderResponseMapper {
    @Mapping(source = "user.fullName", target = "userName")
    @Mapping(source = "event.title", target = "eventTitle")
    OrderResponseDto toDto(Order order);
}
