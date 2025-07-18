package com.example.SiteOfRsvp.service;

import com.example.SiteOfRsvp.dto.EventResponseDto;
import com.example.SiteOfRsvp.dto.EventRsvpFieldDto;
import com.example.SiteOfRsvp.dto.EventRsvpFieldResponseDto;
import com.example.SiteOfRsvp.dto.RsvpRequestDto;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public interface RsvpService {


    List<EventRsvpFieldResponseDto> getAllFieldsThatRsvp(String title);

    void saveRsvp(String eventTitle, RsvpRequestDto rsvpRequestDto);
}
