package com.smartclinic.service;

import com.smartclinic.model.Appointment;
import java.time.LocalDate;
import java.util.List;

public class AppointmentService {

    public Appointment bookAppointment(Appointment appointment) {
        return appointment;
    }

    public List<Appointment> getAppointmentsByDoctorAndDate(
            Long doctorId,
            LocalDate date) {
        return List.of();
    }
}
