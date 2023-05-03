package com.apointmentScheduler.VitrayaAkundu.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private LocalDate dob;
    private String name;
    private String address;
    private GENDER gender;

    public Patient() {
    }

    public Patient(LocalDate dob, String address, GENDER gender, String name) {

        this.dob = dob;
        this.address = address;
        this.gender = gender;
        this.name = name;
        //this.Id = Id;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public LocalDate getDobLocaleDate() {
        return dob;
    }


    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public GENDER getGender() {
        return gender;
    }

    public void setGender(GENDER gender) {
        this.gender = gender;
    }



}
