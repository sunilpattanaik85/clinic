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

import com.clinicexa.clinic.entity.MedicineMaster;
import com.clinicexa.clinic.service.MedicineMasterService;

@RestController
@RequestMapping("/medicineMaster")
public class MedicineMasterController {
	@Autowired
	private MedicineMasterService medicineMasterService;

	@PostMapping
	public ResponseEntity<MedicineMaster> savemedicineMaster(@RequestBody MedicineMaster medicineMaster ) {
		medicineMasterService.saveMedicine(medicineMaster);
		return new ResponseEntity<>(medicineMaster, HttpStatus.CREATED);

	}

	@GetMapping
	public ResponseEntity<List<MedicineMaster>> fetchAll() {
		List<MedicineMaster> list =  medicineMasterService.fetchAll();
		if (list.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
    public ResponseEntity<MedicineMaster> getmedicineById(@PathVariable long id) {
        Optional<MedicineMaster> medicineMaster = medicineMasterService.findById(id);
        
        if (medicineMaster.isPresent()) {
            return new ResponseEntity<>(medicineMaster.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
        }
    }
	@GetMapping("/getByDisease/{id}")
	public ResponseEntity<List<MedicineMaster>> getMedicineByDiseaseId(@PathVariable long id) {
		List<MedicineMaster> medicineMasterList = medicineMasterService.findByDiseaseId(id);

		if (!medicineMasterList.isEmpty()) {
			return new ResponseEntity<>(medicineMasterList, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	 @DeleteMapping("/{id}")
	    public ResponseEntity<String> deleteMedicineMaster(@PathVariable long id) {
	        Optional<MedicineMaster> medicineMasterToDelete = medicineMasterService.findById(id);

	        if (medicineMasterToDelete.isPresent()) {
	        	medicineMasterService.remove(medicineMasterToDelete.get());
	            return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>("Not found", HttpStatus.NOT_FOUND);
	        }
	    }
}
