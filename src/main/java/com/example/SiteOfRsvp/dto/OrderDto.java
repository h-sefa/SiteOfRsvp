package com.example.SiteOfRsvp.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class OrderDto {

    /*
    private String platformOrderId;
    private String  details;
    private UserDto user;
    private EventDto event;
     */
    @NotBlank(message = "Platform sipariş ID boş olamaz")
    @Size(max = 50, message = "Platform sipariş ID 50 karakteri geçemez")
    private String platformOrderId;

    @Size(max = 1000, message = "Detaylar 1000 karakteri geçemez")
    private String details;

    @NotNull(message = "Kullanıcı bilgileri boş olamaz")
    @Valid // İç içe DTO'lar için gerekli
    private UserDto user;

    @NotNull(message = "Etkinlik bilgileri boş olamaz")
    @Valid // İç içe DTO'lar için gerekli
    private EventDto event;


    public OrderDto() {
    }

    public OrderDto(String platformOrderId, String details, UserDto user, EventDto event) {
        this.platformOrderId = platformOrderId;
        this.details = details;
        this.user = user;
        this.event = event;
    }

    //Getter and Setter
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

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public EventDto getEvent() {
        return event;
    }

    public void setEvent(EventDto event) {
        this.event = event;
    }

    //Getter and Setter
}
