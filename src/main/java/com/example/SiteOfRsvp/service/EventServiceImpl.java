package com.example.SiteOfRsvp.service;

import com.example.SiteOfRsvp.dto.EventDto;
import com.example.SiteOfRsvp.dto.EventResponseDto;
import com.example.SiteOfRsvp.dto.EventRsvpFieldMappingDto;
import com.example.SiteOfRsvp.entity.Event;
import com.example.SiteOfRsvp.entity.EventRsvpFieldMapping;
import com.example.SiteOfRsvp.mappers.EventMapper;
import com.example.SiteOfRsvp.mappers.EventResponseMapper;
import com.example.SiteOfRsvp.mappers.EventRsvpFieldMappingMapper;
import com.example.SiteOfRsvp.repository.EventRepository;
import com.example.SiteOfRsvp.repository.EventRsvpFieldMappingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
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


        return allEvent.stream().map(event -> eventResponseMapper.toDto(event)).collect(Collectors.toList());
    }

    @Override
    public EventResponseDto getEventById(Long id) {

        Optional<Event> foundedEventbyId = eventRepository.findById(id);
        if(foundedEventbyId.isPresent()){


            return eventResponseMapper.toDto(foundedEventbyId.get());
        }

        throw new RuntimeException("event with id : " + id + " not found");
    }

    @Override
    public EventResponseDto getEventByTitle(String title) {

        Optional<Event> foundedEntity = eventRepository.findEventByTitle(title);
        if(foundedEntity.isPresent() && foundedEntity.get().getIsPublished()){

            return eventResponseMapper.toDto( foundedEntity.get());
        }


        throw new RuntimeException("Aradığınız event bulunamadı ya da yayına henüz alınmamıştır.");
    }

    @Override
    public Event getEventByTitleForOtherServiceCommunication(String title) {

        return eventRepository.findEventByTitle(title).orElseThrow(() -> new RuntimeException("Event Not Found"));
    }

    @Override
    public EventResponseDto updateEventById(EventDto eventDto, Long id) {
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

        Event foundedEvent = eventRepository.findEventByTitle(title).orElseThrow(() -> new RuntimeException("Not Found"));
        EventResponseDto deletedEventDto = eventResponseMapper.toDto(foundedEvent);
        eventRepository.deleteById(foundedEvent.getId());

        //Event repository de şu şekil bir aql çalıştırmam lazım. gelen title değişkeni ile akalalı olan order bilgisini silecek ve event da silinecek.

        return deletedEventDto;

    }
}
