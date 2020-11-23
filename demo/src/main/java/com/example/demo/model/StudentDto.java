package com.example.demo.model;

import lombok.Data;

import java.util.Date;

@Data
public class StudentDto {
    private String email;
    private String faculty;
    private String name;
    private String surname;
    private Date birthDate;
    private String phoneNumber;
    private String password;
}
