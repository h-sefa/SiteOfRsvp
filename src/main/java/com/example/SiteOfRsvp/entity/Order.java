package com.example.SiteOfRsvp.entity;


import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "order", schema = "managersvpdb")
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Order extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "platform_order_id", unique = true)
    private String platformOrderId;

    private String  details;

    //USER_ID FOREİGN KEY OLACAK...
    // order ---> user      n ->  1



    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "event_id", referencedColumnName = "id")
    private Event event;


    //Getter
    public Long getId() {
        return id;
    }

    public String getPlatformOrderId() {
        return platformOrderId;
    }

    public String getDetails() {
        return details;
    }

    public User getUser() {
        return user;
    }

    public Event getEvent() {
        return event;
    }

    //Setter


    public void setId(Long id) {
        this.id = id;
    }

    public void setPlatformOrderId(String platformOrderId) {
        this.platformOrderId = platformOrderId;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
