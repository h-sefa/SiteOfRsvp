package com.example.SiteOfRsvp.dto;

public class OrderResponseDto {

    private String platformOrderId;
    private String details;
    private String userName;
    private String eventTitle;

    public OrderResponseDto() {
    }

    public OrderResponseDto(String platformOrderId, String details, String userName, String eventTitle) {
        this.platformOrderId = platformOrderId;
        this.details = details;
        this.userName = userName;
        this.eventTitle = eventTitle;
    }


    // Getter and Setter

    public String getPlatformOrderId() {
        return platformOrderId;
    }

    public void setPlatformOrderId(String platformOrderId) {
        this.platformOrderId = platformOrderId;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }


    // Getter and Setter
}
