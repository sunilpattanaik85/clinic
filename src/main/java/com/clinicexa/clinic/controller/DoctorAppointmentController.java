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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clinicexa.clinic.entity.DoctorAppointment;
import com.clinicexa.clinic.service.DoctorAppointmentService;




@RestController
@RequestMapping("/doctorAppointment")

public class DoctorAppointmentController {
	@Autowired
	private DoctorAppointmentService doctorAppointmentService;

	@PostMapping
	public ResponseEntity<DoctorAppointment> saveDoctorAppointment(@RequestBody DoctorAppointment doctorAppointment ) {
		doctorAppointmentService.saveDoctorAppointment(doctorAppointment);
		return new ResponseEntity<>(doctorAppointment, HttpStatus.CREATED);

	}
	
	@PutMapping
	public ResponseEntity<DoctorAppointment> updateDoctorAppointment(@RequestBody DoctorAppointment doctorAppointment ) {
		doctorAppointmentService.saveDoctorAppointment(doctorAppointment);
		return new ResponseEntity<>(doctorAppointment, HttpStatus.CREATED);

	}

	@GetMapping
	public ResponseEntity<List<DoctorAppointment>> fetchAll() {
		List<DoctorAppointment> list =  doctorAppointmentService.findAll();
		if (list.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
    public ResponseEntity<DoctorAppointment> getDoctorAppointmentById(@PathVariable long id) {
        Optional<DoctorAppointment> doctorAppointment = doctorAppointmentService.findById(id);
        
        if (doctorAppointment.isPresent()) {
            return new ResponseEntity<>(doctorAppointment.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
        }
    }

	@GetMapping("/getByDoctor/{doctorId}")
	public ResponseEntity<List<DoctorAppointment>> getDoctorAppointmentByDoctorId(@PathVariable long doctorId) {
		List<DoctorAppointment> list = doctorAppointmentService.findByDoctorId(doctorId);

		if (!list.isEmpty()) {
			return new ResponseEntity<>(list, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	 @DeleteMapping("/{id}")
	    public ResponseEntity<String> deleteDoctorAppointment(@PathVariable long id) {
	        Optional<DoctorAppointment> doctorAppointmentToDelete = doctorAppointmentService.findById(id);

	        if (doctorAppointmentToDelete.isPresent()) {
	        	doctorAppointmentService.remove(doctorAppointmentToDelete.get());
	            return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>("Not found", HttpStatus.NOT_FOUND);
	        }
	    }
}
