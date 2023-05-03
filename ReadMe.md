This a is a basic Doctor's appointment scheduler with CRUD APIs for Doctor, Patient, Appointment. Also a search API for finding Patient, Doctor, Appointments against a string.

This is a Assignment for Vitrya Technologies.

Controllers, Models, Services, Repository canbe found under AppointmentSchedulerVitrayaTech/VitrayaAkundu/src/main/java/com/apointmentScheduler .

This uses apache.commons.lang3 API for fuzzy matching of Strings.
Database used is H2(in memory Database)

APIs for patient: GET: /api/v1/patients
                  GET: /api/v1/patients/{patientid}
                  POST:/api/v1/patients
                  PUT: /api/v1/patients/{patientid}
                  DELETE:/api/v1/patients/{patientid}
                  
APIs for Doctor: GET: /api/v1/doctors
                  GET: /api/v1/doctors/{doctorid}
                  POST:/api/v1/doctors
                  PUT: /api/v1/doctors/{doctorid}
                  DELETE:/api/v1/doctors/{doctorid}
                  
APIs for Appointment: GET: /api/v1/appointments
                      GET: /api/v1/appointments/{appointmentid}
                      POST:/api/v1/appointments
                      PUT: /api/v1/appointments/{appointmentid}
                      DELETE:/api/v1/appointments/{appointmentid}
                      
Serach API for query parameter String : GET: api/v1/search
                                          
                                    
                                    
