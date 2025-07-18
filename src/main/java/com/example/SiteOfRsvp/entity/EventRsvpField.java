package com.example.SiteOfRsvp.entity;

import com.example.SiteOfRsvp.converter.StringListJsonConverter;
import com.vladmihalcea.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "event_rsvp_field", schema = "managersvpdb")

@NoArgsConstructor
@AllArgsConstructor
public class EventRsvpField {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String label;

    @Enumerated(EnumType.STRING)
    @Column(name = "field_type")
    private FieldType fieldType;

    //BU ALAN İÇİN DE BİR DÜŞÜNÜLECEK
    @Column(name = "is_required")
    private Boolean isRequired;


    @Type(JsonType.class)
    @Column(name = "options", columnDefinition = "json")
    private List<String> options;


    @OneToMany(mappedBy = "eventRsvpField", cascade = CascadeType.ALL)
    private List<RsvpAnswer> rsvpAnswer;


    @OneToMany(mappedBy = "eventRsvpField", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("fieldOrder ASC")
    private List<EventRsvpFieldMapping> fieldMappings = new ArrayList<>();




    //Getter and Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public List<RsvpAnswer> getRsvpAnswer() {
        return rsvpAnswer;
    }

    public void setRsvpAnswer(List<RsvpAnswer> rsvpAnswer) {
        this.rsvpAnswer = rsvpAnswer;
    }

    public List<EventRsvpFieldMapping> getFieldMappings() {
        return fieldMappings;
    }

    public void setFieldMappings(List<EventRsvpFieldMapping> fieldMappings) {
        this.fieldMappings = fieldMappings;
    }

    //Getter and Setter


}
