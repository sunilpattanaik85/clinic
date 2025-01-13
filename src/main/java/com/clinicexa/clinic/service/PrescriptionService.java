package com.clinicexa.clinic.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinicexa.clinic.entity.DoctorAppointment;
import com.clinicexa.clinic.entity.Prescription;
import com.clinicexa.clinic.repo.PrescriptionRepository;

@Service
public class PrescriptionService {
	@Autowired
	private PrescriptionRepository prescriptionRepository;
	
	@Transactional
	public void savePrescription(Prescription p) {
		prescriptionRepository.save(p);
	}
	
	public Optional<Prescription> findById(Long id) {
		return prescriptionRepository.findById(id);
	}
	public Optional<Prescription> findByDoctorAppointmentId(Long doctorAppointmentId) {
		return prescriptionRepository.findByDoctorAppointmentId(doctorAppointmentId);
	}
	public List<Prescription> findAll(){
		return prescriptionRepository.findAll();
	}
	@Transactional
	public void remove(Prescription pres) {
		prescriptionRepository.delete(pres);
	}
}
