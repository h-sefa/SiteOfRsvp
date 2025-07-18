package com.example.SiteOfRsvp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "rsvp_answer", schema = "managersvpdb")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RsvpAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //RSVP_ID VE FIELD_ID OLACAK BURADA Kİ CEVAP IN HANGİ EVENT A VE FILED A AIT OLDUĞUNU TUTMAK İÇİN

    private String answer;

    @ManyToOne
    @JoinColumn(name = "rsvp_id")
    private Rsvp rsvp;

    @ManyToOne
    @JoinColumn(name = "event_rsvp_field_id")
    private EventRsvpField eventRsvpField;


}
