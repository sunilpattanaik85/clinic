package com.clinicexa.clinic.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clinicexa.clinic.entity.Prescription;

import java.util.List;
import java.util.Optional;

public interface PrescriptionRepository extends JpaRepository<Prescription, Long>{
    Optional<Prescription> findByDoctorAppointmentId(Long doctorAppointmentId);
}
