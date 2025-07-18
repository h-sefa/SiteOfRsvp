package com.example.SiteOfRsvp.mappers;

import com.example.SiteOfRsvp.dto.EventDto;
import com.example.SiteOfRsvp.dto.EventResponseDto;
import com.example.SiteOfRsvp.dto.UserDto;
import com.example.SiteOfRsvp.entity.Event;
import com.example.SiteOfRsvp.entity.User;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;


@Mapper(componentModel = "spring")
public interface EventMapper {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEventFromDto(EventDto eventDto, @MappingTarget Event event);

    EventDto toDto(Event event);

    Event toEntity(EventDto eventDto);
}
