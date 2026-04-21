package com.zafer.viptransfer.service.abstracts;

import com.zafer.viptransfer.entity.concretes.Appointment;

import java.util.List;

public interface AppointmentService {
    Appointment createAppointment(Appointment appointment);

    List<Appointment> getAllAppointments();

    void deleteAppointmentById(Long id);
}
