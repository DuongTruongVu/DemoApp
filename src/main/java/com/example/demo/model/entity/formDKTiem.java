package com.example.demo.model.entity;

import jakarta.persistence.Column;

public class formDKTiem {
    @Column(name = "id")
    private long id;
    @Column(name = "fullname")
    private String fullName;
    @Column(name = "dateOfBirth")
    private String dateOfBirth;
    @Column(name = "sex")
    private String sex;

    private String city;
    private String quanHuyen;
    private String phone;
    //    private String avatar; //
    private String address;
    //    private String origin;
    private String fullNameNLH;
    private String mlhOfNtiem;
    private String idNumber;
    private String kindVaccine;
    private String Center;
    private String dateOfTiem;
    private boolean status;
}
