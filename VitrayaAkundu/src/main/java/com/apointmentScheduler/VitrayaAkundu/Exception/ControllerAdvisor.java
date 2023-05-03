package com.apointmentScheduler.VitrayaAkundu.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Date;

@EnableWebMvc
@ControllerAdvice
public class ControllerAdvisor {
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.CONFLICT)
    public void handleGenericException(final Exception ex , final WebRequest request) {
        System.out.println("handleGenericException ....");
        //return getExceptionResponse("Failed with Invalid data" + ex.getMessage(), HttpStatus.BAD_REQUEST.value());
    }

    @ExceptionHandler(CannotCreateAppointmentException.class)
    @ResponseStatus(value = HttpStatus.CONFLICT)
    public final ResponseEntity<Object> handleSpecificException(final Exception ex , final WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), "Conflict in creating Appointment",
                request.getDescription(false));
        return new ResponseEntity(exceptionResponse, HttpStatus.CONFLICT);
    }
}
