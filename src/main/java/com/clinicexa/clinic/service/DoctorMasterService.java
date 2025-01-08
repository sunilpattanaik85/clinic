package com.clinicexa.clinic.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinicexa.clinic.entity.DoctorMaster;
import com.clinicexa.clinic.entity.MedicineMaster;
import com.clinicexa.clinic.repo.DoctorMasterRepository;

@Service
public class DoctorMasterService {
	@Autowired
	private DoctorMasterRepository doctorMasterRepository;
	@Transactional
	public void saveDoctorMaster(DoctorMaster dm) {
		doctorMasterRepository.save(dm);
	}
	
	public Optional<DoctorMaster> findById(Long id) {
		return doctorMasterRepository.findById(id);
	}
	
	public List<DoctorMaster> findAll(){
		return doctorMasterRepository.findAll();
	}
	
	@Transactional
	public void remove(DoctorMaster dm) {
		doctorMasterRepository.delete(dm);
	}
}
