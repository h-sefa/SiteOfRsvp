package com.example.SiteOfRsvp.mappers;

import com.example.SiteOfRsvp.dto.RsvpDto;
import com.example.SiteOfRsvp.entity.Rsvp;

public interface RsvpResponseMapper {
    RsvpDto toDto(Rsvp rsvp);

    Rsvp toEntity(RsvpDto rsvpDto);
}
