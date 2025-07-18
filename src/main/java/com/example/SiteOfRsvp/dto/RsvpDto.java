package com.example.SiteOfRsvp.dto;

public class RsvpDto {

    private String guestName;
    private EventDto eventDto;

    public RsvpDto() {
    }

    public RsvpDto(String guestName, EventDto eventDto) {
        this.guestName = guestName;
        this.eventDto = eventDto;
    }

    //Getter and Setter

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public EventDto getEventDto() {
        return eventDto;
    }

    public void setEventDto(EventDto eventDto) {
        this.eventDto = eventDto;
    }

    //Getter and Setter
}
