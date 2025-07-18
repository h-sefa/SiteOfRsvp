package com.example.SiteOfRsvp.dto;

public class RsvpAnswerDto {

    private String answer;
    private RsvpDto rsvp;
    private EventRsvpFieldDto eventRsvpField;


    //Getter and Setter

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public RsvpDto getRsvp() {
        return rsvp;
    }

    public void setRsvp(RsvpDto rsvp) {
        this.rsvp = rsvp;
    }

    public EventRsvpFieldDto getEventRsvpField() {
        return eventRsvpField;
    }

    public void setEventRsvpField(EventRsvpFieldDto eventRsvpField) {
        this.eventRsvpField = eventRsvpField;
    }

    // Getter and Setter
}
