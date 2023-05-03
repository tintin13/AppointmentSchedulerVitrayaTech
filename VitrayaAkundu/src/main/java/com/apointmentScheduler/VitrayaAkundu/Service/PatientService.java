package com.apointmentScheduler.VitrayaAkundu.Service;

import com.apointmentScheduler.VitrayaAkundu.Model.Patient;
import com.apointmentScheduler.VitrayaAkundu.Repository.PatientRepository;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;

@Component("patientservice")
public class PatientService {
    @Autowired
    PatientRepository patientRepository;

    public Optional<Patient> findById(Long patientid) {
        return patientRepository.findById(patientid);
    }

    
    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    public Patient create(Patient patient) {
        return patientRepository.save(patient);
    }

    public Patient update(Long patientId, Patient patient) {
        Optional<Patient> optional = patientRepository.findById(patientId);

        if (optional.isPresent()) {
            // Modify the fields of the entity object
            Patient existingPatient = optional.get();
            existingPatient.setDob(patient.getDobLocaleDate());
            existingPatient.setGender(patient.getGender());
            existingPatient.setAddress(patient.getAddress());

            // Save the entity
            return patientRepository.save(existingPatient);
        }
        return patientRepository.save(patient);
    }

    public void deleteById(Long patientId) {
        patientRepository.deleteById(patientId);
    }
}
