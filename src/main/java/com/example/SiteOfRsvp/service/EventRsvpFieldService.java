package com.example.SiteOfRsvp.service;

import com.example.SiteOfRsvp.dto.EventRsvpFieldDto;
import com.example.SiteOfRsvp.dto.EventRsvpFieldResponseDto;
import com.example.SiteOfRsvp.entity.EventRsvpField;

import java.util.List;

public interface EventRsvpFieldService {

    List<EventRsvpFieldResponseDto> getRsvpFields();

    EventRsvpFieldResponseDto getRsvpFieldById(Long id);

    EventRsvpFieldResponseDto saveRsvpField(EventRsvpFieldDto eventRsvpFieldDto);

    List<EventRsvpFieldResponseDto> saveRsvpField(List<EventRsvpFieldDto> eventRsvpFieldDtos);

    EventRsvpFieldResponseDto updateRsvpField(EventRsvpFieldDto eventRsvpFieldDto, Long id);

    EventRsvpFieldResponseDto deleteRsvpField(Long id);

    EventRsvpField getFieldByLabelForOtherServices(String label);

}
