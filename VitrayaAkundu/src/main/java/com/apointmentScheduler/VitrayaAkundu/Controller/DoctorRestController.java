package com.apointmentScheduler.VitrayaAkundu.Controller;

import com.apointmentScheduler.VitrayaAkundu.Model.Doctor;
import com.apointmentScheduler.VitrayaAkundu.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DoctorRestController {

    @Autowired
    private DoctorService doctorService;

    /** GET request to return specific doctors **/
    @RequestMapping(path = "/api/v1/doctors/{doctorId}", method = RequestMethod.GET)
    public Optional<Doctor> findByDoctorId(@PathVariable Long doctorId) {
        return doctorService.findById(doctorId);
    }

    /** GET request to return all doctors **/
    @RequestMapping(path = "/api/v1/doctors", method = RequestMethod.GET)
    List<Doctor> findAllDoctors() {
        return doctorService.findAll();
    }


    /** POST request to add new doctors **/
    @RequestMapping(path = "/api/v1/doctors", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Doctor create(@RequestBody Doctor doctor) throws Exception {

        return doctorService.create(doctor);

    }


    /** PUT request to update doctors **/
    @RequestMapping(path = "/api/v1/doctors/{doctorId}", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Doctor update(@PathVariable Long doctorId, @RequestBody Doctor doctor) {
        return doctorService.update(doctorId, doctor);
    }



    /** DELETE request to delete specific doctors **/
    @RequestMapping(path = "/api/v1/doctors/{doctorId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    void deleteByDoctorId(@PathVariable Long doctorId) {
        doctorService.deleteById(doctorId);
    }
}
