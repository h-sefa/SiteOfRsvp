package com.example.SiteOfRsvp.service;

import com.example.SiteOfRsvp.dto.EventDto;
import com.example.SiteOfRsvp.dto.EventResponseDto;
import com.example.SiteOfRsvp.entity.Event;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface EventService {

    List<EventResponseDto> getAllEvents();
    EventResponseDto getEventById(Long id);

    EventResponseDto getEventByTitle(String title);
    Event getEventByTitleForOtherServiceCommunication(String title);
    EventResponseDto updateEventById(EventDto eventDto, Long id);

    EventResponseDto deleteEventByTitle(String title);

}
