package com.apointmentScheduler.VitrayaAkundu.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalTime;

//import java.sql.Time;

@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String specialty;
    private LocalTime availabilityStartTime;
    private LocalTime availabilityEndTime;
    public Doctor() {
    }

    public Doctor(String name, String specialty, LocalTime availabilityStartTime, LocalTime availabilityEndTime) {
        this.name = name;
        this.specialty = specialty;
        this.availabilityStartTime = availabilityStartTime;
        this.availabilityEndTime = availabilityEndTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public LocalTime getAvailabilityStartTime() {
        return availabilityStartTime;
    }

    public void setAvailabilityStartTime(LocalTime availabilityStartTime) {
        this.availabilityStartTime = availabilityStartTime;
    }

    public LocalTime getAvailabilityEndTime() {
        return availabilityEndTime;
    }

    public void setAvailabilityEndTime(LocalTime availabilityEndTime) {
        this.availabilityEndTime = availabilityEndTime;
    }


}
