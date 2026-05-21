package com.smartclinic.controller;

import com.smartclinic.service.DoctorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/{doctorId}/availability")
    public ResponseEntity<?> getAvailability(
            @RequestParam String user,
            @PathVariable Long doctorId,
            @RequestParam String date,
            @RequestHeader("Authorization") String token) {

        if(token == null || token.isEmpty()) {
            return ResponseEntity.badRequest()
                    .body("Invalid token");
        }

        return ResponseEntity.ok(
                doctorService.getAvailableSlots(doctorId, date)
        );
    }
}
