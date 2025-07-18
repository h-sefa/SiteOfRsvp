package com.example.SiteOfRsvp.mappers;

import com.example.SiteOfRsvp.dto.OrderDto;
import com.example.SiteOfRsvp.entity.Event;
import com.example.SiteOfRsvp.entity.Order;
import com.example.SiteOfRsvp.entity.User;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {UserMapper.class, EventMapper.class})
public interface OrderMapper {

    OrderDto toDto(Order order);


    Order toEntity(OrderDto orderDto);


//    Order updateOrderFromDto(OrderDto orderDto, @MappingTarget Order order);
//    User updateUserFromDto(Order orderDto, @MappingTarget User user);
//    User updateEventFromDto(Order orderDto, @MappingTarget Event event);

}

