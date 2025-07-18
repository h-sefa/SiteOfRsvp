package com.example.SiteOfRsvp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "rsvp", schema = "managersvpdb")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rsvp extends BaseEntity{
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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "guest_name")
    private String guestName;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;
    //EVENT_ID foreign key olacak !!! VE RSVP_ANSWER GELECEK DÜZENLENECCEK


    @OneToMany(mappedBy = "rsvp", cascade = CascadeType.ALL)
    private List<RsvpAnswer> rsvpAnswers;

}




