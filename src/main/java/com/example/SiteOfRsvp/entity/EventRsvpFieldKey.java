package com.example.SiteOfRsvp.entity;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Embeddable
public class EventRsvpFieldKey implements Serializable {

    private UUID eventId;
    private UUID eventRsvpFieldId;

    public EventRsvpFieldKey() {
    }

    public EventRsvpFieldKey(UUID eventId, UUID eventRsvpFieldId) {
        this.eventId = eventId;
        this.eventRsvpFieldId = eventRsvpFieldId;
    }


    //Getter abd Setter

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
