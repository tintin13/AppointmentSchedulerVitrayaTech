package com.apointmentScheduler.VitrayaAkundu.Repository;

import com.apointmentScheduler.VitrayaAkundu.Model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
