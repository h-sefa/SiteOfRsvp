package com.example.SiteOfRsvp.dto;

import java.util.UUID;

public class RsvpDto {

    private UUID id;
    private String guestName;
    private String eventTitle;

    public RsvpDto() {
    }

    public RsvpDto(UUID id, String guestName, String eventTitle) {
        this.id = id;
        this.guestName = guestName;
        this.eventTitle = eventTitle;
    }

    //Getter and Setter


    public UUID getId() { return id; }

    public void setId(UUID id) { this.id = id; }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    //Getter and Setter
}
