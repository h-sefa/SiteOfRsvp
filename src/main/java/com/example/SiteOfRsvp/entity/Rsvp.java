package com.example.SiteOfRsvp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "rsvp", schema = "managersvpdb")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"event", "rsvpAnswers"})
public class Rsvp extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "guest_name")
    private String guestName;

    @ManyToOne
    @JoinColumn(name = "event_id")
    @JsonIgnore
    private Event event;
    //EVENT_ID foreign key olacak !!! VE RSVP_ANSWER GELECEK DÜZENLENECEK


    @OneToMany(mappedBy = "rsvp", cascade = CascadeType.ALL)
    private List<RsvpAnswer> rsvpAnswers;

}


/*
    @Table(
    name = "rsvp",
    uniqueConstraints = @UniqueConstraint(columnNames = {"event_id", "guest_name"})
)
    //BU KULLANIM SONRA EKLENECEK guest_name e göre değil email eklemesi ile yapılacak
     */


    /*
    guest_mail
    guest_phone
    bunlar rsvp ve eventrsvpField ve rsvpAnswer arasında tabloda tutuluyor

    ************** KUCUK TASARIMSAL BIR CALISMA **************

    --- BİR GUEST OLARAK FORMU DOLDURDUM ---
    --- FORMDA EVENTID İLE HANGİ EVENT OLDUĞU BELLİ ---
    --- LIST OLARAK HANGİ CEVAPLAR VERILDIĞI BELLİ FAKAT HANGİ FİELD LARA NE CEVAP VERILDIGINE BAKARSAK EGER ---


     */




