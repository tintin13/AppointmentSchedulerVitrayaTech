package com.apointmentScheduler.VitrayaAkundu.Controller;

import com.apointmentScheduler.VitrayaAkundu.Model.Appointment;
import com.apointmentScheduler.VitrayaAkundu.Model.Doctor;
import com.apointmentScheduler.VitrayaAkundu.Model.Patient;
import com.apointmentScheduler.VitrayaAkundu.Service.AppointmentService;
import com.apointmentScheduler.VitrayaAkundu.Service.DoctorService;
import com.apointmentScheduler.VitrayaAkundu.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static org.apache.commons.lang3.StringUtils.getFuzzyDistance;

@RestController
public class FuzzySearchController {
    @Autowired
    private PatientService patientService;
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private AppointmentService appointmentService;

    @RequestMapping(path = "/api/v1/search", method = RequestMethod.GET)
    List<Object> findallmatch(@RequestParam("searchString") String query) {
        //return Collections.singletonList(patientService.findAll());
        List<Patient> patientList = patientService.findAll();
        List<Doctor> doctorList = doctorService.findAll();
        List<Appointment> appointmentList = appointmentService.findAll();

        List<Object> objlist = new ArrayList<>();
        for (Appointment appointment : appointmentList) {

            if ((doctorService.findById(appointment.getdoctorId()).isPresent() &&
                    ((getFuzzyDistance(query.toLowerCase(), doctorService.findById(appointment.getdoctorId()).get().getName().toLowerCase(), Locale.UK) > 3) ||
                    (getFuzzyDistance(query.toLowerCase(), doctorService.findById(appointment.getdoctorId()).get().getSpecialty().toLowerCase(), Locale.UK) > 3)))
                ||
                    (patientService.findById(appointment.getpatientId()).isPresent() &&
                    ((getFuzzyDistance(query.toLowerCase(), patientService.findById(appointment.getpatientId()).get().getName().toLowerCase(), Locale.UK) > 3) ||
                    (getFuzzyDistance(query.toLowerCase(), patientService.findById(appointment.getpatientId()).get().getAddress().toLowerCase(), Locale.UK) > 3)))
                )
            {
                objlist.add((Object) appointment);
            }
        }

        for (Patient patient : patientList) {
            if ((getFuzzyDistance(query.toLowerCase(), patient.getName().toLowerCase(), Locale.UK) > 3) ||
                    (getFuzzyDistance(query.toLowerCase(), patient.getAddress().toLowerCase(), Locale.UK) > 3)
            )
            {
                objlist.add((Object) patient);
            }
        }

        for (Doctor doctor : doctorList) {

            if ((getFuzzyDistance(query.toLowerCase(), doctor.getName().toLowerCase(), Locale.UK) > 3) ||
                    (getFuzzyDistance(query.toLowerCase(), doctor.getSpecialty().toLowerCase(), Locale.UK) > 3)
            )
            {
                objlist.add((Object) doctor);
            }
        }
        return objlist;
    }

}
