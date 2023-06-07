package com.example.demo.model.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
@Setter
public class formDKTiemDTO {

    private long id;
    private String fullName;
    private String dateOfBirth;
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

    private AccountDTO accountDTO;
    private long accountId;

    private List<String> teachingClassIdList;

    private String yearCollege1;
    private String yearCollege2;
}
