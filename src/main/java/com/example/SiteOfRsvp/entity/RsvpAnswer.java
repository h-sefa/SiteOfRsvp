package com.example.SiteOfRsvp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "rsvp_answer", schema = "managersvpdb")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"rsvp", "eventRsvpField"} )
public class RsvpAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    //RSVP_ID VE FIELD_ID OLACAK BURADA Kİ CEVAP IN HANGİ EVENT A VE FILED A AIT OLDUĞUNU TUTMAK İÇİN

    private String answer;

    @ManyToOne
    @JoinColumn(name = "rsvp_id")
    @JsonIgnore
    private Rsvp rsvp;

    @ManyToOne
    @JoinColumn(name = "event_rsvp_field_id")
    @JsonIgnore
    private EventRsvpField eventRsvpField;


}
