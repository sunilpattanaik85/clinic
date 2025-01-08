package com.clinicexa.clinic.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinicexa.clinic.entity.DiseaseMaster;
import com.clinicexa.clinic.repo.DiseaseMasterRepository;
@Service
public class DiseaseMasterService {
	@Autowired(required = true)
	private DiseaseMasterRepository diseaseMasterRepository;
	
	@Transactional
	public void saveDiseaseMaster(DiseaseMaster dm) {
		diseaseMasterRepository.save(dm);
	}
	
	public Optional<DiseaseMaster> findById(Long id) {
		return diseaseMasterRepository.findById(id);
	}
	
	public List<DiseaseMaster> findAll(){
		return diseaseMasterRepository.findAll();
	}
	
	@Transactional
	public void remove(DiseaseMaster dm) {
		diseaseMasterRepository.delete(dm);
	}
}
