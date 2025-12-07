package com.example.SiteOfRsvp.controller;


import com.example.SiteOfRsvp.dto.EventDto;
import com.example.SiteOfRsvp.dto.EventResponseDto;
import com.example.SiteOfRsvp.entity.Event;
import com.example.SiteOfRsvp.service.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/event")
public class EventController {

    private  EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public ResponseEntity<List<EventResponseDto>> getAllEvents(){

        List<EventResponseDto> allEvents =eventService.getAllEvents();

        return ResponseEntity.status(HttpStatus.OK).body(allEvents);
    }

    @GetMapping("/active")
    public ResponseEntity<List<EventResponseDto>> getAllActiveEvents(){


        List<EventResponseDto> activeEvents = eventService.getAllActiveEvents();
        return ResponseEntity.status(HttpStatus.OK).body(activeEvents);
    }


    @GetMapping("/inactive")
    public ResponseEntity<List<EventResponseDto>> getAllInactiveEvents(){


        List<EventResponseDto> inactiveEvents = eventService.getAllInactiveEvents();
        return ResponseEntity.status(HttpStatus.OK).body(inactiveEvents);
    }


    @GetMapping("/{id}")
    public ResponseEntity<EventResponseDto> getEventById(@PathVariable UUID id) {

        EventResponseDto eventById = eventService.getEventById(id);

        return ResponseEntity.status(HttpStatus.OK).body(eventById);


    }

    @GetMapping("/title/{title}")
    public ResponseEntity<EventResponseDto> getEventById(@PathVariable String title) {

        EventResponseDto eventByTitle = eventService.getEventByTitle(title);

        return ResponseEntity.status(HttpStatus.OK).body(eventByTitle);


    }



    @PutMapping("/{id}")
    public ResponseEntity<EventResponseDto> updateEvent(@RequestBody EventDto eventDto, @PathVariable UUID id ){

        EventResponseDto updateEventResponseDto = eventService.updateEventById(eventDto, id);

        return ResponseEntity.status(HttpStatus.OK).body(updateEventResponseDto);
    }

    @DeleteMapping("/title/{title}")
    public ResponseEntity<EventResponseDto> deleteEvent(@PathVariable String title ){

        EventResponseDto eventDeletedResponseDto = eventService.deleteEventByTitle(title);

        return ResponseEntity.status(HttpStatus.OK).body(eventDeletedResponseDto);
    }

}
