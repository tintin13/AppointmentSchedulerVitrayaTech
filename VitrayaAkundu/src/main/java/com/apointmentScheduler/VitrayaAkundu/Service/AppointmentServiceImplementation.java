package com.apointmentScheduler.VitrayaAkundu.Service;

import com.apointmentScheduler.VitrayaAkundu.Exception.CannotCreateAppointmentException;
import com.apointmentScheduler.VitrayaAkundu.Repository.AppointmentRepository;
import com.apointmentScheduler.VitrayaAkundu.Model.Appointment;
import com.apointmentScheduler.VitrayaAkundu.Repository.DoctorRepository;
import com.apointmentScheduler.VitrayaAkundu.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.*;

@Component("appointmentService")
public class AppointmentServiceImplementation implements AppointmentService {

    @Autowired
    AppointmentRepository appointmentRepository;
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    PatientRepository patientRepository;

    public AppointmentServiceImplementation() {
    }

    public AppointmentServiceImplementation(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public Optional<Appointment> findById(Long appointmentId) {
        return appointmentRepository.findById(appointmentId);
    }

    @Override
    public List<Appointment> findAll() {
        return appointmentRepository.findAll();
    }

    @Override
    public Appointment create(Appointment appointment) throws Exception {
        List<Appointment> appointmentList = appointmentRepository.findAll();
        /*if(doctorRepository.findById(appointment.getdoctorId()).isPresent()) {
           if((doctorRepository.findById(appointment.getdoctorId()).get().getAvailabilityStartTime().compareTo(appointment.getAppointmentEndTime()) <= 0)
               || (doctorRepository.findById(appointment.getdoctorId()).get().getAvailabilityEndTime().compareTo(appointment.getAppointmentEndTime())  >= 0))
           {
               throw new Exception();
           }
        }*/

        for(Appointment existingAppointment : appointmentList) {
            if((existingAppointment.getAppointmentDate().compareTo(appointment.getAppointmentDate()) == 0)
                && (existingAppointment.getdoctorId() == appointment.getdoctorId())
                && ((existingAppointment.getAppointmentStartTime().compareTo(appointment.getAppointmentEndTime()) <= 0)
                    && (existingAppointment.getAppointmentEndTime().compareTo(appointment.getAppointmentStartTime()) >= 0))
                )
            {
                throw new CannotCreateAppointmentException();
            }
          // (appointment.getAppointmentEndTime().compareTo(existingAppointment.getAppointmentEndTime())|| || || (appointment.getRoomId() == existingAppointment.getRoomId())))
        }
        return appointmentRepository.save(appointment);
    }

    @Override
    public Appointment update(Long appointmentId, Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public void deleteById(Long appointmentId) {
        appointmentRepository.deleteById(appointmentId);
    }
}
