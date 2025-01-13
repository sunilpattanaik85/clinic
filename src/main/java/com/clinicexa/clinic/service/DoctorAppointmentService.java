package com.clinicexa.clinic.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.clinicexa.clinic.dto.DoctorAppointmentDetails;
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

	public List<DoctorAppointment> findByDoctorIdWithoutStatus(Long id) {
		return doctorAppointmentRepository.findByDoctorIdWithoutStatus(id);
	}
	
	public List<DoctorAppointment> findAll(){
		return doctorAppointmentRepository.findAll();
	}
	@Transactional
	public void remove(DoctorAppointment dm) {
		doctorAppointmentRepository.delete(dm);
	}

	public List<DoctorAppointmentDetails> fetchAllDADetailsWithPrescription(Long doctorAppId){
		List<DoctorAppointmentDetails>  list = new ArrayList<>();
		List<Object[]> Objlist=doctorAppointmentRepository.fetchAllDADetailsWithPrescription(doctorAppId);
		for(Object[] obj:Objlist){
			DoctorAppointmentDetails obj1 = new DoctorAppointmentDetails();
			SimpleDateFormat sm = new SimpleDateFormat("dd-MM-yyyy");
			String strDate = sm.format(String.valueOf(obj[0]));
			obj1.setStrDateOfAppointment(strDate);
			obj1.setDoctorName(String.valueOf(obj[1]));
			obj1.setPatientName(String.valueOf(obj[2]));
			obj1.setDiseaseName(String.valueOf(obj[3]));
			obj1.setMedicineName(String.valueOf(obj[4]));
			obj1.setAppointmentStatus(String.valueOf(obj[5]));
			if(obj1.getAppointmentStatus().equalsIgnoreCase("A")){
				obj1.setAppointmentStatus("Appointed");
			}
			if(obj1.getAppointmentStatus().equalsIgnoreCase("P")){
				obj1.setAppointmentStatus("Prescribed");
			}
			list.add(obj1);
		}
		return list;
	}
}
