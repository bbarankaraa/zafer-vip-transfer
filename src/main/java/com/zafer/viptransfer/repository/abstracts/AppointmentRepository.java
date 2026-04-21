package com.zafer.viptransfer.repository.abstracts;

import com.zafer.viptransfer.entity.concretes.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

}
