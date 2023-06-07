package com.example.demo.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "tiem")
public class Tiem extends BaseEntity {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private Account account;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "address")
    private String address;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "origin")
    private String origin;

    @Column(name = "id_number")
    private String idNumber;

    @Column(name = "id_photo")
    private String idPhoto;

    @Column(name = "card_photo")
    private String cardPhoto;

    @Column(name = "degree_photo")
    private String degreePhoto;

    @Column(name = "school")
    private String school;

    @Column(name = "specialization")
    private String specialization;

    @Column(name = "year_college")
    private String yearCollege;

    @Column(name = "level")
    private String level;

    @Column(name = "advantage")
    private String advantage;

    @Column(name = "status")
    private boolean status;

    public Tiem orElse(Object o) {
        return null;
    }
}
