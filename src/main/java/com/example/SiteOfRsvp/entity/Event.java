package com.example.SiteOfRsvp.entity;


import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "event", schema = "managersvpdb")
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Event extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(name = "expires_at")
    private LocalDateTime expiresAt;

    @Column(name = "is_published")
    private Boolean isPublished;


    @OneToOne(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true)
    private Order order;
    //ORDER_ID FREIGN KEY OLARAK EKLENECEK

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<Rsvp> rsvpList;


    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("fieldOrder ASC")
    private List<EventRsvpFieldMapping> fieldMappings = new ArrayList<>();


    //Getter and Setter


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
}
