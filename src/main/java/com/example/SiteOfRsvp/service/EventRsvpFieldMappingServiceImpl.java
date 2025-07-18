package com.example.SiteOfRsvp.service;

import com.example.SiteOfRsvp.dto.EventRsvpFieldMappingDto;
import com.example.SiteOfRsvp.dto.EventRsvpFieldMappingResponseDto;
import com.example.SiteOfRsvp.entity.EventRsvpFieldMapping;
import com.example.SiteOfRsvp.mappers.EventMapper;
import com.example.SiteOfRsvp.mappers.EventRsvpFieldMappingMapper;
import com.example.SiteOfRsvp.repository.EventRepository;
import com.example.SiteOfRsvp.repository.EventRsvpFieldMappingRepository;
import org.springframework.stereotype.Service;

@Service
public class EventRsvpFieldMappingServiceImpl implements EventRsvpFieldMappingService{

    private EventRsvpFieldMappingRepository eventRsvpFieldMappingRepository;
    private EventRepository eventRepository;
    private EventMapper eventMapper;
    private EventRsvpFieldMappingMapper eventRsvpFieldMappingMapper;



    public EventRsvpFieldMappingServiceImpl(EventRsvpFieldMappingRepository eventRsvpFieldMappingRepository, EventRepository eventRepository, EventMapper eventMapper, EventRsvpFieldMappingMapper eventRsvpFieldMappingMapper) {
        this.eventRsvpFieldMappingRepository = eventRsvpFieldMappingRepository;
        this.eventRepository = eventRepository;
        this.eventMapper = eventMapper;
        this.eventRsvpFieldMappingMapper = eventRsvpFieldMappingMapper;
    }

    @Override
    public EventRsvpFieldMapping updateEventRsvpFields(EventRsvpFieldMappingDto eventRsvpFieldMappingDto) {

        EventRsvpFieldMapping entity = eventRsvpFieldMappingMapper.toEntity(eventRsvpFieldMappingDto);

        EventRsvpFieldMapping eventRsvpFieldMapping =eventRsvpFieldMappingRepository.save(entity);

//        EventRsvpFieldMappingResponseDto eventRsvpFieldMappingResponseDto = eventRsvpFieldMappingMapper.toResponseDto(eventRsvpFieldMapping);

        return eventRsvpFieldMapping;
    }
}
