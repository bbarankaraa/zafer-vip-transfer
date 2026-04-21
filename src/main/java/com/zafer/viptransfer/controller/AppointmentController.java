package com.zafer.viptransfer.controller;

import com.zafer.viptransfer.entity.concretes.Appointment;
import com.zafer.viptransfer.service.abstracts.AppointmentService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/appointments")
@RequiredArgsConstructor
@CrossOrigin(origins = "https://zafer-vip-transfer-frontend.vercel.app")
public class AppointmentController {

    private final AppointmentService appointmentService;

    @PostMapping(path = "/create")
    public ResponseEntity<?> createAppointment(@RequestBody Appointment appointment) {
        try {
            Appointment savedAppointment = appointmentService.createAppointment(appointment);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedAppointment);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Randevu Oluşturulamadı: " + e.getMessage());
        }
    }

    @GetMapping(path = "/all")
    public ResponseEntity<?> getAllAppointments() {
        List<Appointment> appointmentList = appointmentService.getAllAppointments();
        return ResponseEntity.ok(appointmentList);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<?> deleteAppointmentById(@PathVariable Long id) {
        try {
            appointmentService.deleteAppointmentById(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Randevu bulunamadı, silme işlemi yapılamadı.");
        }
    }
}
