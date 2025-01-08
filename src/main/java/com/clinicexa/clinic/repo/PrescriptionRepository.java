package com.clinicexa.clinic.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clinicexa.clinic.entity.Prescription;

public interface PrescriptionRepository extends JpaRepository<Prescription, Long>{

}
