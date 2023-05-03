package com.apointmentScheduler.VitrayaAkundu.Controller;

import com.apointmentScheduler.VitrayaAkundu.Model.Patient;
import com.apointmentScheduler.VitrayaAkundu.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

import static org.apache.commons.lang3.StringUtils.*;

@RestController
public class PatientRestController extends ResponseEntityExceptionHandler {
    @Autowired
    private PatientService patientService;

    /** GET request to return specific patients **/
    @RequestMapping(path = "/api/v1/patients/{patientId}", method = RequestMethod.GET)
    public Optional<Patient> findByPatientId(@PathVariable Long patientId) {
        return patientService.findById(patientId);
    }

    /** GET request to return all patients **/
    @RequestMapping(path = "/api/v1/patients", method = RequestMethod.GET)
    List<Patient> findAllPatients() {
        return patientService.findAll();
    }


    /** POST request to add new patients **/
    @RequestMapping(path = "/api/v1/patients", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Patient create(@RequestBody Patient patient) throws Exception {

        return patientService.create(patient);

    }


    /** PUT request to update patients **/
    @RequestMapping(path = "/api/v1/patients/{patientId}", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Patient update(@PathVariable Long patientId, @RequestBody Patient patient) {
        return patientService.update(patientId, patient);
    }



    /** DELETE request to delete specific patients **/
    @RequestMapping(path = "/api/v1/patients/{patientId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    void deleteByPatientId(@PathVariable Long patientId) {
        patientService.deleteById(patientId);
    }

}
