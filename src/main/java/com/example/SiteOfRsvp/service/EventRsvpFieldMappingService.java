package com.example.SiteOfRsvp.service;

import com.example.SiteOfRsvp.dto.EventDto;
import com.example.SiteOfRsvp.dto.EventResponseDto;
import com.example.SiteOfRsvp.dto.EventRsvpFieldMappingDto;
import com.example.SiteOfRsvp.dto.EventRsvpFieldMappingResponseDto;
import com.example.SiteOfRsvp.entity.EventRsvpFieldMapping;

public interface EventRsvpFieldMappingService {



    EventRsvpFieldMapping updateEventRsvpFields(EventRsvpFieldMappingDto eventRsvpFieldMappingDto);
}
