package com.example.SiteOfRsvp.mappers;

import com.example.SiteOfRsvp.dto.EventRsvpFieldMappingDto;
import com.example.SiteOfRsvp.dto.EventRsvpFieldMappingResponseDto;
import com.example.SiteOfRsvp.entity.EventRsvpFieldMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface EventRsvpFieldMappingResponseMapper {

    @Mapping(source = "eventRsvpField.id", target ="eventRsvpFieldId")
    @Mapping(source = "event.id", target = "eventId")
    EventRsvpFieldMappingResponseDto toDto(EventRsvpFieldMapping eventRsvpFieldMapping);
}
