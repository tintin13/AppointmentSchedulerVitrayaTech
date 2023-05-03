package com.apointmentScheduler.VitrayaAkundu;

import com.apointmentScheduler.VitrayaAkundu.Exception.ControllerAdvisor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(ControllerAdvisor.class)

public class VitrayaAkunduApplication {

	public static void main(String[] args) {
		SpringApplication.run(VitrayaAkunduApplication.class, args);
	}

}
