package com.smartclinic.service;

import java.util.List;
import org.springframework.http.ResponseEntity;

public class DoctorService {

    public List<String> getAvailableSlots(
            Long doctorId,
            String date) {

        return List.of(
                "09:00",
                "11:00",
                "14:00");
    }

    public ResponseEntity<?> validateLogin(
            String email,
            String password) {

        if(email.equals("doctor@clinic.com")
                && password.equals("password")) {
            return ResponseEntity.ok(
                    "Login successful");
        }

        return ResponseEntity.badRequest()
                .body("Invalid credentials");
    }
}
