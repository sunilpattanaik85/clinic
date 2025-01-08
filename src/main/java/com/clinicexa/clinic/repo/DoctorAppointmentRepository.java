package com.clinicexa.clinic.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clinicexa.clinic.entity.DoctorAppointment;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DoctorAppointmentRepository extends JpaRepository<DoctorAppointment, Long>{
    @Query(value = "select * from doctor_appointment where patient_status='A' and doctor_id=?1", nativeQuery = true)
    List<DoctorAppointment> findByDoctorId(Long doctorId);
}
