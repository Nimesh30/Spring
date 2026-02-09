package com.Student.StudentApp.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "dob")
    private String dob;
    @Column(name = "gender")
    private String gender;
    @Column(name = "admission_date")
    private Date admissionDate;
    @Column(name = "class")
    private String className;
    @Column(name = "city")
    private String city;
    @Column(name = "state_code")
    private String stateCode;
    @Column(name = "country")
    private String country;



}
