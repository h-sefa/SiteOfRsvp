package com.example.SiteOfRsvp.mappers;

import com.example.SiteOfRsvp.dto.EventDto;
import com.example.SiteOfRsvp.dto.EventRsvpFieldDto;
import com.example.SiteOfRsvp.entity.Event;
import com.example.SiteOfRsvp.entity.EventRsvpField;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EventRsvpFieldMapper {

    EventRsvpFieldDto toDto(EventRsvpField eventRsvpField);

    @Mapping(source = "isRequired", target= "isRequired")
    EventRsvpField toEntity(EventRsvpFieldDto eventRsvpFieldDto);
}
