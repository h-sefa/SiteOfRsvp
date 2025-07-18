package com.example.SiteOfRsvp.dto;

public class EventRsvpFieldMappingResponseDto {
    private Long eventId;
    private Long eventRsvpFieldId;
    private Integer fieldOrder;

    public EventRsvpFieldMappingResponseDto() {
    }

    public EventRsvpFieldMappingResponseDto(Long eventId, Long eventRsvpFieldId, Integer fieldOrder) {
        this.eventId = eventId;
        this.eventRsvpFieldId = eventRsvpFieldId;
        this.fieldOrder = fieldOrder;
    }

    //Getter and Setter

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Long getEventRsvpFieldId() {
        return eventRsvpFieldId;
    }

    public void setEventRsvpFieldId(Long eventRsvpFieldId) {
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
