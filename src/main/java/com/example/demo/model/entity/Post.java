package com.example.demo.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "post")
public class Post extends BaseEntity {

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "formDKTiem_id")
    private formDKTiem formDKTiem;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "account_id")
    private Account account;

    @Column(name = "fullName")
    private String fullName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @Column(name = "price")
    private double price;

    @Column(name = "number_of_session")
    private int numberOfSession;

    @Column(name = "information")
    private String information;

    @Column(name = "requirement")
    private String requirement;

    @Column(name = "mode")
    private String mode;

    @Column(name = "progress")
    private String progress;

    @Column(name = "status")
    private boolean status;

}
