package com.example.SiteOfRsvp.dto;

import java.util.UUID;

public class EventRsvpFieldMappingResponseDto {
    private UUID eventId;
    private UUID eventRsvpFieldId;
    private Integer fieldOrder;

    public EventRsvpFieldMappingResponseDto() {
    }

    public EventRsvpFieldMappingResponseDto(UUID eventId, UUID eventRsvpFieldId, Integer fieldOrder) {
        this.eventId = eventId;
        this.eventRsvpFieldId = eventRsvpFieldId;
        this.fieldOrder = fieldOrder;
    }

    //Getter and Setter

    public UUID getEventId() {
        return eventId;
    }

    public void setEventId(UUID eventId) {
        this.eventId = eventId;
    }

    public UUID getEventRsvpFieldId() {
        return eventRsvpFieldId;
    }

    public void setEventRsvpFieldId(UUID eventRsvpFieldId) {
        this.eventRsvpFieldId = eventRsvpFieldId;
    }

    public Integer getFieldOrder() {
        return fieldOrder;
    }

    public void setFieldOrder(Integer fieldOrder) {
        this.fieldOrder = fieldOrder;
    }


    //Getter and Setter
}
