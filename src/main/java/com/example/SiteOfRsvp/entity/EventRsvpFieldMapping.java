package com.example.SiteOfRsvp.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "event_event_rsvp_field", schema = "managersvpdb")
public class EventRsvpFieldMapping {

    @EmbeddedId
    private EventRsvpFieldKey id = new EventRsvpFieldKey();

    @ManyToOne
    @MapsId("eventId")
    @JoinColumn(name = "event_id")
    private Event event;

    @ManyToOne
    @MapsId("eventRsvpFieldId")
    @JoinColumn(name = "event_rsvp_field_id")
    private EventRsvpField eventRsvpField;

    @Column(name = "field_order")
    private Integer fieldOrder;

    // Getter and Setter

    public EventRsvpFieldKey getId() {
        return id;
    }

    public void setId(EventRsvpFieldKey id) {
        this.id = id;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public EventRsvpField getEventRsvpField() {
        return eventRsvpField;
    }

    public void setEventRsvpField(EventRsvpField eventRsvpField) {
        this.eventRsvpField = eventRsvpField;
    }

    public Integer getFieldOrder() {
        return fieldOrder;
    }

    public void setFieldOrder(Integer fieldOrder) {
        this.fieldOrder = fieldOrder;
    }


    //Getter and Setter

}
