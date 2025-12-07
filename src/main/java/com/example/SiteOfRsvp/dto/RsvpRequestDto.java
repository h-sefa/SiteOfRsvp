package com.example.SiteOfRsvp.dto;


import java.util.List;

public class RsvpRequestDto {


    //

    private String guestName;
    private List<AnswerDto> answers;

    public RsvpRequestDto(String guestName, List<AnswerDto> answers) {
        this.guestName = guestName;
        this.answers = answers;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public List<AnswerDto> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerDto> answers) {
        this.answers = answers;
    }
}
