package com.example.SiteOfRsvp.service;

import com.example.SiteOfRsvp.dto.*;
import com.example.SiteOfRsvp.entity.Event;
import com.example.SiteOfRsvp.entity.EventRsvpFieldMapping;
import com.example.SiteOfRsvp.entity.Rsvp;
import com.example.SiteOfRsvp.exception.ResourceNotFoundException;
import com.example.SiteOfRsvp.mappers.EventMapper;
import com.example.SiteOfRsvp.mappers.EventResponseMapper;
import com.example.SiteOfRsvp.mappers.EventRsvpFieldMappingMapper;
import com.example.SiteOfRsvp.repository.EventRepository;
import com.example.SiteOfRsvp.repository.EventRsvpFieldMappingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class EventServiceImpl implements EventService{

    private EventRepository eventRepository;
    private EventResponseMapper eventResponseMapper;
    private EventMapper eventMapper;
    private EventRsvpFieldMappingMapper eventRsvpFieldMappingMapper;

    private EventRsvpFieldMappingService eventRsvpFieldMappingService;
    private EventRsvpFieldMappingRepository eventRsvpFieldMappingRepository;

    public EventServiceImpl(EventRepository eventRepository, EventResponseMapper eventResponseMapper, EventMapper eventMapper, EventRsvpFieldMappingMapper eventRsvpFieldMappingMapper, EventRsvpFieldMappingService eventRsvpFieldMappingService, EventRsvpFieldMappingRepository eventRsvpFieldMappingRepository) {
        this.eventRepository = eventRepository;
        this.eventResponseMapper = eventResponseMapper;
        this.eventMapper = eventMapper;
        this.eventRsvpFieldMappingMapper = eventRsvpFieldMappingMapper;
        this.eventRsvpFieldMappingService = eventRsvpFieldMappingService;
        this.eventRsvpFieldMappingRepository = eventRsvpFieldMappingRepository;
    }

    @Override
    public List<EventResponseDto> getAllEvents() {

        List<Event> allEvent = eventRepository.findAll();

        if (allEvent.isEmpty()) {
            throw new ResourceNotFoundException("No events found in the system.");
        }


        return allEvent.stream().map(event -> eventResponseMapper.toDto(event)).collect(Collectors.toList());
    }

    @Override
    public EventResponseDto getEventById(UUID id) {

        Event foundedEventbyId = eventRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No events found with id : " + id));

        return eventResponseMapper.toDto(foundedEventbyId);
    }

    //Doldurulacak
    @Override
    public List<EventResponseDto> getAllActiveEvents() {

        List<Event> activeEvents =  eventRepository.findActiveEvents();

        List<EventResponseDto> activeEventResponseDto = new ArrayList<>();
        for (Event activeEvent : activeEvents) {
            EventResponseDto dto = eventResponseMapper.toDto(activeEvent);
            activeEventResponseDto.add(dto);
        }

        return activeEventResponseDto;


    }

    //Doldurulacak
    @Override
    public List<EventResponseDto> getAllInactiveEvents() {

        List<Event> inactiveEvents =  eventRepository.findInactiveEvents();

        List<EventResponseDto> inactiveEventResponseDto = new ArrayList<>();
        for (Event inactiveEvent : inactiveEvents) {
            EventResponseDto dto = eventResponseMapper.toDto(inactiveEvent);
            inactiveEventResponseDto.add(dto);
        }

        return inactiveEventResponseDto;

    }

    @Override
    public EventResponseDto getEventByTitle(String title) {


        Event foundedEntity = eventRepository.findEventByTitle(title).orElseThrow(() -> new ResourceNotFoundException("No events found with title : " + title + " or has not published yet") );


        if(foundedEntity.getIsPublished()){

            return eventResponseMapper.toDto( foundedEntity);
        }


        throw new RuntimeException("Aradığınız event bulunamadı ya da yayına henüz alınmamıştır.");
    }

    @Override
    public Event getEventByTitleForOtherServiceCommunication(String title) {

        return eventRepository.findEventByTitle(title).orElseThrow(() -> new ResourceNotFoundException("Event Not Found with title : " + title));
    }

    @Override
    public EventResponseDto updateEventById(EventDto eventDto, UUID id) {
        Event foundedEventById = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event with is : " + id + " not found"));
        // TODO: JOIN TABLOSU ICIN SERVICE YAZMAYA KARAR VERDIM. BU ASAMADAN BASLAYACAGIM.

        // bir event buldum id ye göre
        // bu event a eğer fieldmapping gelirse onu da eventfieldMappingService aracılığı ile güncelleyeeğim
        //gelmezse gelen diğer alanları güncelleyeceğim.

        if(eventDto.getFieldMappings() != null){

            eventDto.getFieldMappings().forEach(fieldMapping -> {
                EventRsvpFieldMappingDto newEventRsvpFieldMappingDto = new EventRsvpFieldMappingDto(id, fieldMapping.getEventRsvpFieldId(), fieldMapping.getFieldOrder());

                EventRsvpFieldMapping eventRsvpFieldMapping =   eventRsvpFieldMappingService.updateEventRsvpFields(newEventRsvpFieldMappingDto);

                EventRsvpFieldMapping newEntity  = eventRsvpFieldMappingRepository.save(eventRsvpFieldMapping);

            });

        //Buraya düzgün bir dönüş eklenecek Bu deneme
            return new EventResponseDto();
        }

        throw new RuntimeException("Hata field eklemesi");

    }

    @Override
    public EventResponseDto deleteEventByTitle(String title) {

        Event foundedEvent = eventRepository.findEventByTitle(title).orElseThrow(() -> new ResourceNotFoundException("Not Found Event with Ttile : " + title));
        EventResponseDto deletedEventDto = eventResponseMapper.toDto(foundedEvent);
        eventRepository.deleteById(foundedEvent.getId());

        //Event repository de şu şekil bir aql çalıştırmam lazım. gelen title değişkeni ile akalalı olan order bilgisini silecek ve event da silinecek.

        return deletedEventDto;


        //TODO: DT = 18.09.25
        // Delete işleminden hangi entity ler etkilencek kontrol edilecek.

    }


    //DENEME ICIN
    @Override
    public DashboardDataDto forDashboardData(String title) {

        Event event = eventRepository.findEventWithOrderAndRsvpByTitle(title)
                .orElseThrow(() -> new ResourceNotFoundException("Event Bulunamadı."));

        // manuel mapping — mapstruct kullanma
        DashboardDataDto dto = new DashboardDataDto();
        dto.setEventTitle(event.getTitle());
        dto.setRsvpExpirationDate(event.getExpiresAt());
        dto.setPublished(Boolean.TRUE.equals(event.getIsPublished())); // veya isPublished getter'a göre

        // platformOrderId örnek: ilk order
        if (event.getOrder() != null) dto.setPlatformOrderId(event.getOrder().getPlatformOrderId());

        List<RsvpDto> rsvps = new ArrayList<>();
        if (event.getRsvpList() != null) {
            for (Rsvp r : event.getRsvpList()) {
                RsvpDto rDto = new RsvpDto();
                rDto.setGuestName(r.getGuestName());
                rDto.setEventTitle(event.getTitle()); // sadece title
                rsvps.add(rDto);
            }
        }
        dto.setRsvpList(rsvps);
        return dto;





//        Event event = eventRepository.findEventWithOrderAndRsvpByTitle(title).orElseThrow(() -> new ResourceNotFoundException("Event Bulunamadı."));
//
//        System.out.println(event);
//
//        System.out.println("Hi burada kalman lazım");
//    return eventResponseMapper.toDashboardDataDto(event);
    }
}
