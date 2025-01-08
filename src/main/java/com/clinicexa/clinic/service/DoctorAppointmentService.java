package com.clinicexa.clinic.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinicexa.clinic.entity.DoctorAppointment;
import com.clinicexa.clinic.repo.DoctorAppointmentRepository;

@Service
public class DoctorAppointmentService {
	
	@Autowired
	private DoctorAppointmentRepository doctorAppointmentRepository;
	@Transactional
	public void saveDoctorAppointment(DoctorAppointment dm) {
		doctorAppointmentRepository.save(dm);
	}
	
	public Optional<DoctorAppointment> findById(Long id) {
		return doctorAppointmentRepository.findById(id);
	}

	public List<DoctorAppointment> findByDoctorId(Long id) {
		return doctorAppointmentRepository.findByDoctorId(id);
	}
	
	public List<DoctorAppointment> findAll(){
		return doctorAppointmentRepository.findAll();
	}
	@Transactional
	public void remove(DoctorAppointment dm) {
		doctorAppointmentRepository.delete(dm);
	}
}
