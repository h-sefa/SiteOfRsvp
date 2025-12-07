package com.example.SiteOfRsvp.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "event", schema = "managersvpdb")
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Event extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String title;

    @Column(name = "expires_at")
    private LocalDateTime expiresAt;

    @Column(name = "is_published")
    private Boolean isPublished;


    @OneToOne(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Order order;
    //ORDER_ID FOREIGN KEY OLARAK EKLENECEK

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<Rsvp> rsvpList;


    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("fieldOrder ASC")
    private List<EventRsvpFieldMapping> fieldMappings = new ArrayList<>();


    //Getter and Setter


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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

    public void setIsPublished(Boolean isPublished) {
        this.isPublished = isPublished;
    }



    public List<Rsvp> getRsvpList() {
        return rsvpList;
    }

    public void setRsvpList(List<Rsvp> rsvpList) {
        this.rsvpList = rsvpList;
    }

    public List<EventRsvpFieldMapping> getFieldMappings() {
        return fieldMappings;
    }

    public void setFieldMappings(List<EventRsvpFieldMapping> fieldMappings) {
        this.fieldMappings = fieldMappings;
    }

    public Order getOrder() {
        return order;
    }
    public void setOrder(Order order) {
        this.order = order;
    }
}
