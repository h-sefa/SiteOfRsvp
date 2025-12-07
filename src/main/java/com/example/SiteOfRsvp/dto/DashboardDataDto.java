package com.example.SiteOfRsvp.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = "rsvpList")
public class DashboardDataDto {

    private String platformOrderId;
    private LocalDateTime rsvpExpirationDate;
    private String eventTitle;
    private boolean isPublished;
    private List<RsvpDto> rsvpList;

    public DashboardDataDto(String platformOrderId, LocalDateTime rsvpExpirationDate, String eventTitle, boolean isPublished, List<RsvpDto> rsvpList) {
        this.platformOrderId = platformOrderId;
        this.rsvpExpirationDate = rsvpExpirationDate;
        this.eventTitle = eventTitle;
        this.isPublished = isPublished;
        this.rsvpList = rsvpList;
    }
}
