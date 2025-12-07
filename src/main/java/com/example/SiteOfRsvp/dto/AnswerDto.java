package com.example.SiteOfRsvp.dto;

import java.util.UUID;

public class AnswerDto {

    private UUID id;
    private String label;
    private String answer;

    public AnswerDto(UUID id, String label, String answer) {
        this.id = id;
        this.label = label;
        this.answer = answer;
    }

    public UUID getId() { return id; }

    public void setId(UUID id) { this.id = id; }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }


}
