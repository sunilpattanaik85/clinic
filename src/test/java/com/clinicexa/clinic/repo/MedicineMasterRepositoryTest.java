package com.clinicexa.clinic.repo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.clinicexa.clinic.entity.DiseaseMaster;
import com.clinicexa.clinic.entity.MedicineMaster;

@DataJpaTest
public class MedicineMasterRepositoryTest {
	@Autowired
	private MedicineMasterRepository medicineMasterRepository;
	
	@BeforeEach
    void setUp() {
		//diseaseMasterRepo.deleteAll();  // Clean up the repository before each test
		MedicineMaster mm1 = new MedicineMaster("Sulfatrim",new Long(1));
		MedicineMaster mm2 = new MedicineMaster("Bactrim",new Long(1));
		MedicineMaster mm3 = new MedicineMaster("Lomotil",new Long(1));
		MedicineMaster mm4 = new MedicineMaster("Aspirin",new Long(2));
		MedicineMaster mm5 = new MedicineMaster("Acetaminophen",new Long(2));
		MedicineMaster mm6 = new MedicineMaster("Prochlorperazine",new Long(2));
		MedicineMaster mm7 = new MedicineMaster("Cetirizine",new Long(3));
		MedicineMaster mm8 = new MedicineMaster("Desloratadine",new Long(3));
		MedicineMaster mm9 = new MedicineMaster("Loratadine",new Long(3));
		medicineMasterRepository.save(mm1);
		medicineMasterRepository.save(mm2);
		medicineMasterRepository.save(mm3);
		medicineMasterRepository.save(mm4);
		medicineMasterRepository.save(mm5);
		medicineMasterRepository.save(mm6);
		medicineMasterRepository.save(mm7);
		medicineMasterRepository.save(mm8);
		medicineMasterRepository.save(mm9);
        
	}
	 @Test
	 public void testInsertMultipleUsers() {
	        // Insert multiple users
	        
	        // Validate that the users are saved and retrieved correctly
	        assertEquals(9, medicineMasterRepository.count());
	        
	       List<MedicineMaster> list = medicineMasterRepository.findAll();
	       
	       list.forEach(System.out::println);
	    }
}
