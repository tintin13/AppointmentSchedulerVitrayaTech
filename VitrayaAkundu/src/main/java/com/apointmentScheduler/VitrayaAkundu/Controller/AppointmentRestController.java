package com.apointmentScheduler.VitrayaAkundu.Controller;

import com.apointmentScheduler.VitrayaAkundu.Service.AppointmentService;
import com.apointmentScheduler.VitrayaAkundu.Model.Appointment;
import com.apointmentScheduler.VitrayaAkundu.Service.DoctorService;
import com.apointmentScheduler.VitrayaAkundu.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.Optional;


@RestController

public class AppointmentRestController extends ResponseEntityExceptionHandler {

    @Autowired
    private PatientService patientService;
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private AppointmentService appointmentService;

    public AppointmentRestController() {
    }

    public AppointmentRestController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }


    /** GET request to return specific appointments **/
    @RequestMapping(path = "/api/v1/appointments/{appointmentId}", method = RequestMethod.GET)
    public Optional<Appointment> findById(@PathVariable Long appointmentId) {
        return appointmentService.findById(appointmentId);
    }

    /** GET request to return all appointments **/
    @RequestMapping(path = "/api/v1/appointments", method = RequestMethod.GET)
    List<Appointment> findAllAppointments() {
        return appointmentService.findAll();
    }

    /** POST request to add new appointments **/
    @RequestMapping(path = "/api/v1/appointments", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Appointment create(@RequestBody Appointment appointment) throws Exception {

            return appointmentService.create(appointment);

    }


    /** PUT request to update appointments **/
    @RequestMapping(path = "/api/v1/appointments/{appointmentId}", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Appointment update(@PathVariable Long appointmentId, @RequestBody Appointment appointment) {
        return appointmentService.update(appointmentId, appointment);
    }



    /** DELETE request to delete specific appointments **/
    @RequestMapping(path = "/api/v1/appointments/{appointmentId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    void deleteById(@PathVariable Long appointmentId) {
        appointmentService.deleteById(appointmentId);
    }




}
