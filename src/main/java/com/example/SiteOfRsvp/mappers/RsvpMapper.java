package com.example.SiteOfRsvp.mappers;

import com.example.SiteOfRsvp.dto.OrderDto;
import com.example.SiteOfRsvp.dto.RsvpDto;
import com.example.SiteOfRsvp.dto.RsvpRequestDto;
import com.example.SiteOfRsvp.entity.Event;
import com.example.SiteOfRsvp.entity.EventRsvpField;
import com.example.SiteOfRsvp.entity.Order;
import com.example.SiteOfRsvp.entity.Rsvp;
import com.example.SiteOfRsvp.service.EventRsvpFieldService;
import com.example.SiteOfRsvp.service.EventService;
import com.example.SiteOfRsvp.service.RsvpService;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface RsvpMapper {

    RsvpDto toDto(Rsvp rsvp);


    @Mapping(source = "label", target = "event",  qualifiedByName = "foundEventWithLabel")
    @Mapping(source = "rsvpRequestDto.guestName", target = "guestName")
    Rsvp toEntity (String label, RsvpRequestDto rsvpRequestDto, @Context EventService eventService);

    @Named("foundEventWithLabel")
    default Event foundEventWithLabel(String label, @Context EventService eventService) {
        return eventService.getEventByTitleForOtherServiceCommunication(label);

    }
}
