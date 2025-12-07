package com.example.SiteOfRsvp.service;

import com.example.SiteOfRsvp.dto.EventRsvpFieldDto;
import com.example.SiteOfRsvp.dto.EventRsvpFieldResponseDto;
import com.example.SiteOfRsvp.entity.EventRsvpField;

import java.util.List;
import java.util.UUID;

public interface EventRsvpFieldService {

    List<EventRsvpFieldResponseDto> getRsvpFields();

    EventRsvpFieldResponseDto getRsvpFieldById(UUID id);

    EventRsvpFieldResponseDto saveRsvpField(EventRsvpFieldDto eventRsvpFieldDto);

    List<EventRsvpFieldResponseDto> saveRsvpField(List<EventRsvpFieldDto> eventRsvpFieldDtos);

    EventRsvpFieldResponseDto updateRsvpField(EventRsvpFieldDto eventRsvpFieldDto, UUID id);

    EventRsvpFieldResponseDto deleteRsvpField(UUID id);

    EventRsvpField getFieldByLabelForOtherServices(String label);

}
