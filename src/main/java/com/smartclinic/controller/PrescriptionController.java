package com.smartclinic.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionController {

    @PostMapping
    public ResponseEntity<?> savePrescription(
            @RequestHeader("Authorization") String token,
            @RequestBody Object prescription) {

        if(token == null || token.isEmpty()) {
            return ResponseEntity.badRequest()
                    .body("Invalid token");
        }

        return ResponseEntity.ok(
                "Prescription saved successfully"
        );
    }
}
