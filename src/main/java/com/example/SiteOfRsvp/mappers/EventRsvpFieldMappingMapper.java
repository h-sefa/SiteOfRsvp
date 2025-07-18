package com.example.SiteOfRsvp.mappers;

import com.example.SiteOfRsvp.dto.EventRsvpFieldMappingDto;
import com.example.SiteOfRsvp.dto.EventRsvpFieldMappingResponseDto;
import com.example.SiteOfRsvp.entity.Event;
import com.example.SiteOfRsvp.entity.EventRsvpField;
import com.example.SiteOfRsvp.entity.EventRsvpFieldMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EventRsvpFieldMappingMapper {

//    @Mapping(source = "eventId", target = "event.id")
//    @Mapping(source = "eventRsvpFieldId", target = "eventRsvpField.id")
//    EventRsvpFieldMapping toEntity(EventRsvpFieldMappingDto eventRsvpFieldMappingDto);

    //

    default EventRsvpFieldMapping toEntity(EventRsvpFieldMappingDto dto) {
        if (dto == null) {
            return null;
        }

        EventRsvpFieldMapping entity = new EventRsvpFieldMapping();

        Event event = new Event();
        event.setId(dto.getEventId());

        EventRsvpField field = new EventRsvpField();
        field.setId(dto.getEventRsvpFieldId());

        entity.setEvent(event);
        entity.setEventRsvpField(field);
        entity.setFieldOrder(dto.getFieldOrder());

        return entity;
    }

    //


    @Mapping(source = "eventRsvpField.id", target ="eventRsvpFieldId")
    @Mapping(source = "event.id", target ="eventId")
    EventRsvpFieldMappingDto toDto(EventRsvpFieldMapping eventRsvpFieldMapping);

//    @Mapping(source = "eventRsvpFieldId", target ="eventRsvpFieldId")
//    @Mapping(source = "eventId", target ="eventId")
//    EventRsvpFieldMappingResponseDto toResponseDto(EventRsvpFieldMapping eventRsvpFieldMapping);
}
