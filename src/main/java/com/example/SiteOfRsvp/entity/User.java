package com.example.SiteOfRsvp.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "user", schema = "managersvpdb")
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(unique = true)
    private String email;
    private String password;

    @Column(name = "full_name")
    private String fullName;

    @Enumerated(EnumType.STRING)
    private Roles role;


    //
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Order> orderList;


    // Getter ve Setter


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }
}


/*
        Entity sınıflarına setter ve getter olaylarını OLAYSIZBİR ŞEKİLDE LOMBOK PROBLEM ÇIKARTMAZ İSE
        DENEYECEĞİM. B NOKTADA ŞİMDİLİK KONTROLLE KATMANI İLE BİR DENEYİM DÜŞÜNÜYORUM.

        - Veri tabanında entity ler üzerinde şema bilgisi kontrol edilmelidir.

        -Bazı validate anotasyonları eklnebilir. UNIQUE DURUMU ÖNEMLİ BİR KONU !!!!!! KONTROL EDİLECEK
 */
