package com.clinicexa.clinic.repo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.clinicexa.clinic.entity.DiseaseMaster;
@DataJpaTest
public class DiseaseMasterRepositoryTest {
	@Autowired
	private DiseaseMasterRepository diseaseMasterRepo;
	
	@BeforeEach
    void setUp() {
		//diseaseMasterRepo.deleteAll();  // Clean up the repository before each test
		DiseaseMaster dm1 = new DiseaseMaster("Diarrhea");
        DiseaseMaster dm2 = new DiseaseMaster("Headaches");
        DiseaseMaster dm3 = new DiseaseMaster("Allergies");
        diseaseMasterRepo.save(dm1);
        diseaseMasterRepo.save(dm2);
        diseaseMasterRepo.save(dm3);
	}
	 @Test
	 public void testInsertMultipleUsers() {
	        // Insert multiple users
	        
	        // Validate that the users are saved and retrieved correctly
	        assertEquals(3, diseaseMasterRepo.count());
	        
	       List<DiseaseMaster> list = diseaseMasterRepo.findAll();
	       
	       list.forEach(System.out::println);
	    }
}
