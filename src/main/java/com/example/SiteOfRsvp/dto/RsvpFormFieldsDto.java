package com.example.SiteOfRsvp.dto;

import com.example.SiteOfRsvp.entity.FieldType;

import java.util.List;


//Bu class ısilebilirim şimdilik kullanmayacağım.
public class RsvpFormFieldsDto {

    private String label;
    private FieldType fieldType;
    private Boolean isRequired;
    private List<String> options;
}
