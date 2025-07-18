package com.example.SiteOfRsvp.mappers;

import com.example.SiteOfRsvp.dto.AnswerDto;
import com.example.SiteOfRsvp.dto.OrderDto;
import com.example.SiteOfRsvp.dto.RsvpAnswerDto;
import com.example.SiteOfRsvp.entity.EventRsvpField;
import com.example.SiteOfRsvp.entity.Order;
import com.example.SiteOfRsvp.entity.RsvpAnswer;
import com.example.SiteOfRsvp.service.EventRsvpFieldService;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface RsvpAnswerMapper {


    @Mapping(source = "label", target = "eventRsvpField", qualifiedByName = "labelToEventRsvpField")
    RsvpAnswer toEntity(AnswerDto answerDto, @Context EventRsvpFieldService fieldService);

    @Named("labelToEventRsvpField")
    default EventRsvpField labelToEventRsvpField(String label, @Context EventRsvpFieldService fieldService) {
        return fieldService.getFieldByLabelForOtherServices(label);

    }

    // Dönüşte DTO'ya çevirme istersen
    RsvpAnswerDto toDto(RsvpAnswer entity);
}
