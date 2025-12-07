package com.example.SiteOfRsvp.service;

import com.example.SiteOfRsvp.dto.DashboardDataDto;
import com.example.SiteOfRsvp.dto.EventDto;
import com.example.SiteOfRsvp.dto.EventResponseDto;
import com.example.SiteOfRsvp.entity.Event;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

public interface EventService {

    List<EventResponseDto> getAllEvents();
    EventResponseDto getEventById(UUID id);
    List<EventResponseDto> getAllActiveEvents();
    List<EventResponseDto> getAllInactiveEvents();

    EventResponseDto getEventByTitle(String title);
    Event getEventByTitleForOtherServiceCommunication(String title);
    EventResponseDto updateEventById(EventDto eventDto, UUID id);

    EventResponseDto deleteEventByTitle(String title);



    //DENEME ICIN
    DashboardDataDto forDashboardData (String title);


}
