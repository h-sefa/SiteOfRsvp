package com.example.SiteOfRsvp.mappers;


import com.example.SiteOfRsvp.dto.EventDto;
import com.example.SiteOfRsvp.dto.EventResponseDto;
import com.example.SiteOfRsvp.entity.Event;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EventResponseMapper {

    @Mapping(source = "title", target ="title")
    @Mapping(source = "expiresAt", target  ="expiresAt")
    @Mapping(source = "isPublished", target  ="isPublished")
    @Mapping(source = "fieldMappings", target  ="fieldMappings")
    EventResponseDto toDto(Event event);

}
