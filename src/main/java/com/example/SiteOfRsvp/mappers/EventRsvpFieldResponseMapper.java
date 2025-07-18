package com.example.SiteOfRsvp.mappers;

import com.example.SiteOfRsvp.dto.EventRsvpFieldResponseDto;
import com.example.SiteOfRsvp.entity.EventRsvpField;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EventRsvpFieldResponseMapper {

    @Mapping(source = "isRequired", target = "isRequired")
    EventRsvpFieldResponseDto toDto(EventRsvpField eventRsvpField);
}
