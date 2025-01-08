package com.clinicexa.clinic.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinicexa.clinic.entity.DiseaseMaster;
import com.clinicexa.clinic.entity.MedicineMaster;
import com.clinicexa.clinic.repo.MedicineMasterRepository;

@Service
public class MedicineMasterService {
	
	@Autowired
	private MedicineMasterRepository medicineMasterRepository;
	@Transactional
	public void saveMedicine(MedicineMaster mediMaster) {
		medicineMasterRepository.save(mediMaster);
	}
	public Optional<MedicineMaster> findById(Long id) {
		return medicineMasterRepository.findById(id);
	}
	public List<MedicineMaster> fetchAll(){
		return medicineMasterRepository.findAll();
	}
	public List<MedicineMaster> findByDiseaseId(Long diseaseId){
		return medicineMasterRepository.findByDiseaseId(diseaseId);
	}
	@Transactional
	public void remove(MedicineMaster mm) {
		medicineMasterRepository.delete(mm);
	}
}
