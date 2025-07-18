package com.example.SiteOfRsvp.dto;

public class AnswerDto {

    private String label;
    private String answer;

    public AnswerDto(String label, String answer) {
        this.label = label;
        this.answer = answer;
    }

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

    /*
    answer.setAnswer(answerDto.getAnswer());
        answer.setRsvp(rsvp);
        answer.setEventRsvpField(field);
        rsvpAnswerRepository.save(answer);
     */
}
