package com.apointmentScheduler.VitrayaAkundu.Model;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


@Entity
public class Appointment {

    private @Id @GeneratedValue Long id;
    private Timestamp createdAt = new Timestamp(System.currentTimeMillis());
    private LocalDate appointmentDate;
    private LocalTime appointmentStartTime;
    private LocalTime appointmentEndTime;
    private Long doctorId;
    private Long patientId;
    private Long roomId;


    private AppointmentStatus status = AppointmentStatus.Booked;

    public Appointment() {

    }

    public Appointment(Timestamp createdAt, LocalDate appointmentDate, LocalTime appointmentStartTime, LocalTime appointmentEndTime,  Long doctorId, AppointmentStatus status,  Long patientId, Long roomId) {
        this.createdAt = createdAt;
        this.appointmentDate = appointmentDate;
        this.appointmentStartTime = appointmentStartTime;
        this.appointmentEndTime = appointmentEndTime;
        this.doctorId = doctorId;
        this.status = status;
        this.patientId = patientId;
        this.roomId = roomId;
    }

    public Long getdoctorId() {
        return doctorId;
    }

    public void setdoctorId( Long doctorId) {
        this.doctorId = doctorId;
    }


    public Long getpatientId() {
        return patientId;
    }

    public void setpatientId( Long patientId) {
        this.patientId = patientId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(createdAt);
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public String getAppointmentDate() {
        return appointmentDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public LocalTime getAppointmentStartTime() {
        return appointmentStartTime;
    }

    public void setAppointmentStartTime(LocalTime appointmentStartTime) {
        this.appointmentStartTime = appointmentStartTime;
    }

    public LocalTime getAppointmentEndTime() {
        return appointmentEndTime;
    }

    public void setAppointmentEndTime(LocalTime appointmentEndTime) {
        this.appointmentEndTime = appointmentEndTime;
    }



    public AppointmentStatus getStatus() {
        return status;
    }

    public void setStatus(AppointmentStatus status) {
        this.status = status;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

}
