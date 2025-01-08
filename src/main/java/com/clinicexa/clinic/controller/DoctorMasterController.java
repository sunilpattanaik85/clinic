package com.clinicexa.clinic.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clinicexa.clinic.entity.DoctorMaster;
import com.clinicexa.clinic.service.DoctorMasterService;




@RestController
@RequestMapping("/doctorMaster")
public class DoctorMasterController {
	@Autowired
	private DoctorMasterService doctorMasterService;

	@PostMapping
	public ResponseEntity<DoctorMaster> saveDoctorMaster(@RequestBody DoctorMaster doctorMaster ) {
		doctorMasterService.saveDoctorMaster(doctorMaster);
		return new ResponseEntity<>(doctorMaster, HttpStatus.CREATED);

	}

	@GetMapping
	public ResponseEntity<List<DoctorMaster>> fetchAll() {
		List<DoctorMaster> list =  doctorMasterService.findAll();
		if (list.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
    public ResponseEntity<DoctorMaster> getDoctorById(@PathVariable long id) {
        Optional<DoctorMaster> doctorMaster = doctorMasterService.findById(id);
        
        if (doctorMaster.isPresent()) {
            return new ResponseEntity<>(doctorMaster.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
        }
    }
	
	 @DeleteMapping("/{id}")
	    public ResponseEntity<String> deleteDoctorMaster(@PathVariable long id) {
	        Optional<DoctorMaster> doctorMasterToDelete = doctorMasterService.findById(id);

	        if (doctorMasterToDelete.isPresent()) {
	        	doctorMasterService.remove(doctorMasterToDelete.get());
	            return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>("Not found", HttpStatus.NOT_FOUND);
	        }
	    }
}
