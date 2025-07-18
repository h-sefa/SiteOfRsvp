package com.example.SiteOfRsvp.dto;

import com.example.SiteOfRsvp.entity.EventRsvpFieldMapping;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EventResponseDto {
    private String title;
    private LocalDateTime expiresAt;
    private Boolean isPublished;
    private List<EventRsvpFieldMapping> fieldMappings = new ArrayList<>();



    public EventResponseDto() {
    }

    public EventResponseDto(String title, LocalDateTime expiresAt, Boolean isPublished, List<EventRsvpFieldMapping> fieldMappings) {
        this.title = title;
        this.expiresAt = expiresAt;
        this.isPublished = isPublished;
        this.fieldMappings = fieldMappings;

    }


    //Getter and Setter

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(LocalDateTime expiresAt) {
        this.expiresAt = expiresAt;
    }

    public Boolean getIsPublished() {
        return isPublished;
    }

    public void setIsPublished(Boolean published) {
        isPublished = published;
    }

    public List<EventRsvpFieldMapping> getFieldMappings() {
        return fieldMappings;
    }

    public void setFieldMappings(List<EventRsvpFieldMapping> fieldMappings) {
        this.fieldMappings = fieldMappings;
    }


    //Getter and Setter
}
