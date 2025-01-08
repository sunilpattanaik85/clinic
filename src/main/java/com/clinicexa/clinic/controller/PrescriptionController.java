package com.clinicexa.clinic.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clinicexa.clinic.entity.Prescription;
import com.clinicexa.clinic.service.PrescriptionService;



@RestController
@RequestMapping("/prescription")
public class PrescriptionController {
	@Autowired
	private PrescriptionService prescriptionService;

	@PostMapping
	public ResponseEntity<Prescription> savePrescription(@RequestBody Prescription prescription ) {
		prescriptionService.savePrescription(prescription);
		return new ResponseEntity<>(prescription, HttpStatus.CREATED);

	}

	@GetMapping
	public ResponseEntity<List<Prescription>> fetchAll() {
		List<Prescription> list =  prescriptionService.findAll();
		if (list.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
    public ResponseEntity<Prescription> getDoctorById(@PathVariable long id) {
        Optional<Prescription> prescription = prescriptionService.findById(id);
        
        if (prescription.isPresent()) {
            return new ResponseEntity<>(prescription.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
        }
    }
	
	 @DeleteMapping("/{id}")
	    public ResponseEntity<String> deletePrescription(@PathVariable long id) {
	        Optional<Prescription> prescriptionToDelete = prescriptionService.findById(id);

	        if (prescriptionToDelete.isPresent()) {
	        	prescriptionService.remove(prescriptionToDelete.get());
	            return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>("Not found", HttpStatus.NOT_FOUND);
	        }
	    }
}
