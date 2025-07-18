package com.example.SiteOfRsvp.service;

import com.example.SiteOfRsvp.dto.*;
import com.example.SiteOfRsvp.entity.*;
import com.example.SiteOfRsvp.mappers.EventRsvpFieldMapper;
import com.example.SiteOfRsvp.mappers.RsvpAnswerMapper;
import com.example.SiteOfRsvp.mappers.RsvpMapper;
import com.example.SiteOfRsvp.repository.RsvpAnswerRepository;
import com.example.SiteOfRsvp.repository.RsvpRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class RsvpServiceImpl implements RsvpService{

    private EventService eventService;
    private EventRsvpFieldMapper eventRsvpFieldMapper;
    private  EventRsvpFieldService eventRsvpFieldService;
    private RsvpMapper rsvpMapper;
    private RsvpAnswerMapper rsvpAnswerMapper;
    private RsvpRepository rsvpRepository;
    private RsvpAnswerRepository rsvpAnswerRepository;


    public RsvpServiceImpl(EventService eventService, EventRsvpFieldMapper eventRsvpFieldMapper, EventRsvpFieldService eventRsvpFieldService, RsvpMapper rsvpMapper, RsvpAnswerMapper rsvpAnswerMapper, RsvpRepository rsvpRepository, RsvpAnswerRepository rsvpAnswerRepository) {
        this.eventService = eventService;
        this.eventRsvpFieldMapper = eventRsvpFieldMapper;
        this.eventRsvpFieldService = eventRsvpFieldService;
        this.rsvpMapper = rsvpMapper;
        this.rsvpAnswerMapper = rsvpAnswerMapper;
        this.rsvpRepository = rsvpRepository;
        this.rsvpAnswerRepository = rsvpAnswerRepository;
    }

    @Override
    public List<EventRsvpFieldResponseDto> getAllFieldsThatRsvp(String title) {

        EventResponseDto eventByTitle = eventService.getEventByTitle(title);


       List<Long> ids = eventByTitle.getFieldMappings().stream().map(field -> {
            return field.getEventRsvpField().getId();
        }).collect(Collectors.toList());



        return ids.stream().map(id -> eventRsvpFieldService.getRsvpFieldById(id) ).collect(Collectors.toList());

    }

    @Override
    public void saveRsvp(String eventTitle, RsvpRequestDto rsvpRequestDto) {


       //Gelen rsvp cevaplarını rsvpService eventRsvpFieldService ve eventService ı kullanarak Rsvp ve RsvpAnswer entity kayıtlarını yapıyorum.Mapper aracılığı ile entity dönüşümleri gerçekleşiyor.

        Rsvp newRsvp = rsvpMapper.toEntity(eventTitle, rsvpRequestDto, eventService);
        Rsvp createdRsvp = rsvpRepository.save(newRsvp);

        List<AnswerDto> answers = rsvpRequestDto.getAnswers();
        List<RsvpAnswer> rsvpAnswers =answers.stream().map((answerDto)->{
            RsvpAnswer rsvpAnswer = rsvpAnswerMapper.toEntity(answerDto, eventRsvpFieldService);
            rsvpAnswer.setRsvp(createdRsvp);
            return rsvpAnswer;

        }).collect(Collectors.toList());
        rsvpAnswerRepository.saveAll(rsvpAnswers);


    }
}
