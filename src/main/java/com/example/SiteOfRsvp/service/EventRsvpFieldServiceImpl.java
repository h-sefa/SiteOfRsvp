package com.example.SiteOfRsvp.service;

import com.example.SiteOfRsvp.dto.EventRsvpFieldDto;
import com.example.SiteOfRsvp.dto.EventRsvpFieldResponseDto;
import com.example.SiteOfRsvp.entity.EventRsvpField;
import com.example.SiteOfRsvp.mappers.EventRsvpFieldMapper;
import com.example.SiteOfRsvp.mappers.EventRsvpFieldResponseMapper;
import com.example.SiteOfRsvp.repository.EventRsvpFieldRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EventRsvpFieldServiceImpl implements EventRsvpFieldService{

    private final EventRsvpFieldRepository eventRsvpFieldRepository;
    private final EventRsvpFieldMapper eventRsvpFieldMapper;
    private final EventRsvpFieldResponseMapper eventRsvpFieldResponseMapper;

    public EventRsvpFieldServiceImpl(EventRsvpFieldRepository eventRsvpFieldRepository, EventRsvpFieldMapper eventRsvpFieldMapper, EventRsvpFieldResponseMapper eventRsvpFieldResponseMapper) {
        this.eventRsvpFieldRepository = eventRsvpFieldRepository;
        this.eventRsvpFieldMapper = eventRsvpFieldMapper;
        this.eventRsvpFieldResponseMapper = eventRsvpFieldResponseMapper;
    }

    @Override
    public List<EventRsvpFieldResponseDto> getRsvpFields() {
        List<EventRsvpField> foundedFields = eventRsvpFieldRepository.findAll();

        return foundedFields.stream().map(eventRsvpFieldResponseMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public EventRsvpFieldResponseDto getRsvpFieldById(UUID id) {
        Optional<EventRsvpField> rsvpFieldbyId = eventRsvpFieldRepository.findById(id);
        if(rsvpFieldbyId.isPresent()){
            return eventRsvpFieldResponseMapper.toDto(rsvpFieldbyId.get());
        }

        return null;
    }

    @Override
    public EventRsvpFieldResponseDto saveRsvpField(EventRsvpFieldDto eventRsvpFieldDto) {
        EventRsvpField newRsvpField = eventRsvpFieldMapper.toEntity(eventRsvpFieldDto);
        EventRsvpField savedField = eventRsvpFieldRepository.save(newRsvpField);
       return  eventRsvpFieldResponseMapper.toDto(savedField);


    }

    @Override
    public List<EventRsvpFieldResponseDto> saveRsvpField(List<EventRsvpFieldDto> eventRsvpFieldDtos) {



        List<EventRsvpFieldResponseDto> addedFields = eventRsvpFieldDtos.stream().map(fieldDto -> {

            EventRsvpField eventRsvpField = eventRsvpFieldMapper.toEntity(fieldDto);
            EventRsvpField savedField = eventRsvpFieldRepository.save(eventRsvpField);
            return eventRsvpFieldResponseMapper.toDto(savedField);
        }).toList();

        return addedFields;
    }

    @Override
    public EventRsvpFieldResponseDto updateRsvpField(EventRsvpFieldDto eventRsvpFieldDto, UUID id) {

        Optional<EventRsvpField> foundedRsvpFieldById = eventRsvpFieldRepository.findById(id);
        if(foundedRsvpFieldById.isPresent()){
            foundedRsvpFieldById.get().setFieldType(eventRsvpFieldDto.getFieldType());
            foundedRsvpFieldById.get().setOptions(eventRsvpFieldDto.getOptions());
            foundedRsvpFieldById.get().setLabel(eventRsvpFieldDto.getLabel());
            foundedRsvpFieldById.get().setIsRequired(eventRsvpFieldDto.getIsRequired());

            EventRsvpField updatedRsvpField = eventRsvpFieldRepository.save(foundedRsvpFieldById.get());
            return eventRsvpFieldResponseMapper.toDto(updatedRsvpField);
        }

        //Bulunamazsa hata oluştur.
        return null;
    }

    @Override
    public EventRsvpFieldResponseDto deleteRsvpField(UUID id) {
        Optional<EventRsvpField> deletedRsvpFieldbyId = eventRsvpFieldRepository.findById(id);
        EventRsvpFieldResponseDto deletedRsvpFielddto = eventRsvpFieldResponseMapper.toDto(deletedRsvpFieldbyId.get());
        if(deletedRsvpFieldbyId.isPresent()){
            eventRsvpFieldRepository.deleteById(id);
            return deletedRsvpFielddto;
        }

        return null;



    }

    @Override
    public EventRsvpField getFieldByLabelForOtherServices(String label) {
        return eventRsvpFieldRepository.findByLabel(label).orElseThrow(() -> new RuntimeException("Field not Found"));
    }
}
