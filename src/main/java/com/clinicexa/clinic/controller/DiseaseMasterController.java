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

import com.clinicexa.clinic.entity.DiseaseMaster;
import com.clinicexa.clinic.service.DiseaseMasterService;





@RestController
@RequestMapping("/diseaseMaster")
public class DiseaseMasterController {
	@Autowired
	private DiseaseMasterService diseaseMasterService;

	@PostMapping
	public ResponseEntity<DiseaseMaster> saveDiseaseMaster(@RequestBody DiseaseMaster diseaseMaster ) {
		diseaseMasterService.saveDiseaseMaster(diseaseMaster);
		return new ResponseEntity<>(diseaseMaster, HttpStatus.CREATED);

	}

	@GetMapping
	public ResponseEntity<List<DiseaseMaster>> fetchAll() {
		List<DiseaseMaster> list =  diseaseMasterService.findAll();
		if (list.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
    public ResponseEntity<DiseaseMaster> getDiseaseById(@PathVariable long id) {
        Optional<DiseaseMaster> diseaseMaster = diseaseMasterService.findById(id);
        
        if (diseaseMaster.isPresent()) {
            return new ResponseEntity<>(diseaseMaster.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
        }
    }
	
	 @DeleteMapping("/{id}")
	    public ResponseEntity<String> deleteDiseaseMaster(@PathVariable long id) {
	        Optional<DiseaseMaster> diseaseMasterToDelete = diseaseMasterService.findById(id);

	        if (diseaseMasterToDelete.isPresent()) {
	        	diseaseMasterService.remove(diseaseMasterToDelete.get());
	            return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>("Not found", HttpStatus.NOT_FOUND);
	        }
	    }

}
