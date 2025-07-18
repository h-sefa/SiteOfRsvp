package com.example.SiteOfRsvp.dto;

import com.example.SiteOfRsvp.entity.FieldType;

import java.util.List;

public class EventRsvpFieldResponseDto {
    private String label;
    private FieldType fieldType;
    private Boolean isRequired;
    private List<String> options;

    public EventRsvpFieldResponseDto() {
    }

    public EventRsvpFieldResponseDto(String label, FieldType fieldType, Boolean isRequired, List<String> options) {
        this.label = label;
        this.fieldType = fieldType;
        this.isRequired = isRequired;
        this.options = options;
    }



    //Getter and Setter

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public FieldType getFieldType() {
        return fieldType;
    }

    public void setFieldType(FieldType fieldType) {
        this.fieldType = fieldType;
    }

    public Boolean getIsRequired() {
        return isRequired;
    }

    public void setIsRequired(Boolean required) {
        isRequired = required;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }
}
