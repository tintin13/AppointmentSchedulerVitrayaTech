package com.apointmentScheduler.VitrayaAkundu.Service;

import com.apointmentScheduler.VitrayaAkundu.Model.Doctor;
import com.apointmentScheduler.VitrayaAkundu.Repository.DoctorRepository;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;

@Component("doctorservice")
public class DoctorService {
    @Autowired
    DoctorRepository doctorRepository;

    public Optional<Doctor> findById(Long doctorId) {
        return doctorRepository.findById(doctorId);
    }


    public List<Doctor> findAll() {
        return doctorRepository.findAll();
    }

    /*
    public List<Doctor> findByDateRangeSortedByPrice(LocalDate startDate, LocalDate endDate) {
        return doctorRepository.findAllByAppointmentDateBetweenOrderByPriceAsc(startDate, endDate);
    }*/

    public Doctor create(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

   // public Doctor update(Long doctorId, Doctor doctor) {return doctorRepository.save(doctor);}

    public Doctor update(Long doctorId, Doctor doctor) {
        //patientId
        Optional<Doctor> optional = doctorRepository.findById(doctorId);

        if (optional.isPresent()) {
            // Modify the fields of the entity object
            Doctor existingDoctor = optional.get();
            existingDoctor.setName(doctor.getName());
            existingDoctor.setSpecialty(doctor.getSpecialty());
            existingDoctor.setAvailabilityStartTime(doctor.getAvailabilityStartTime());
            existingDoctor.setAvailabilityEndTime(doctor.getAvailabilityEndTime());


            // Save the entity
            return doctorRepository.save(doctor);
        }
        return doctorRepository.save(doctor);
    }

    public void deleteById(Long doctorId) {
        doctorRepository.deleteById(doctorId);
    }
}

