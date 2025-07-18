package com.example.SiteOfRsvp.entity;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EventRsvpFieldKey implements Serializable {

    private Long eventId;
    private Long eventRsvpFieldId;

    public EventRsvpFieldKey() {
    }

    public EventRsvpFieldKey(Long eventId, Long eventRsvpFieldId) {
        this.eventId = eventId;
        this.eventRsvpFieldId = eventRsvpFieldId;
    }


    //Getter abd Setter

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EventRsvpFieldKey that)) return false;
        return Objects.equals(eventId, that.eventId) && Objects.equals(eventRsvpFieldId, that.eventRsvpFieldId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventId, eventRsvpFieldId);
    }

    //Getter abd Setter
}
