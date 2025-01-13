package com.clinicexa.clinic.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.clinicexa.clinic.dto.DoctorAppointmentDetails;
import com.clinicexa.clinic.entity.*;
import com.clinicexa.clinic.service.*;
import com.lowagie.text.DocumentException;
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

import javax.servlet.http.HttpServletResponse;


@RestController
@RequestMapping("/doctorAppointment")

public class DoctorAppointmentController {
	@Autowired
	private DoctorAppointmentService doctorAppointmentService;
	@Autowired
	private DoctorMasterService doctorMasterService;
	@Autowired
	private DiseaseMasterService diseaseMasterService;
	@Autowired
	private MedicineMasterService medicineMasterService;
	@Autowired
	private PrescriptionService prescriptionService;

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
    public ResponseEntity<DoctorAppointment> getDoctorAppointmentById(@PathVariable long id) throws ParseException {
        Optional<DoctorAppointment> doctorAppointment = doctorAppointmentService.findById(id);
        
        if (doctorAppointment.isPresent()) {
			DoctorAppointment doctorAppointment1 = doctorAppointment.get();
			SimpleDateFormat sm = new SimpleDateFormat("dd-MM-yyyy");
			String strDate = sm.format(doctorAppointment1.getDateOfAppointment());
			doctorAppointment1.setStrDateOfAppointment(strDate);
            return new ResponseEntity<>(doctorAppointment1, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
        }
    }
	@GetMapping("/fetchAllDA/{doctorId}")
	public ResponseEntity<List<DoctorAppointmentDetails>> fetchAllDADetailsWithPrescription(@PathVariable long doctorId) throws ParseException {
		List<DoctorAppointmentDetails> doctorAppointmentDtls = new ArrayList<>();
		List<DoctorAppointment> list = doctorAppointmentService.findByDoctorIdWithoutStatus(doctorId);
		for (DoctorAppointment doctorAppointment:list){
			DoctorAppointmentDetails doctorAppointmentDetails = new DoctorAppointmentDetails();
			SimpleDateFormat sm = new SimpleDateFormat("dd-MM-yyyy");
			String strDate = sm.format(doctorAppointment.getDateOfAppointment());
			doctorAppointmentDetails.setDoctorAppointmentId(doctorAppointment.getDoctorAppointmentId());
			doctorAppointmentDetails.setStrDateOfAppointment(strDate);
			doctorAppointmentDetails.setPatientName(doctorAppointment.getPatientName());
			Optional<DoctorMaster> doctorMasterDtl = doctorMasterService.findById(doctorId);
			if(doctorMasterDtl.isPresent())
			{
				doctorAppointmentDetails.setDoctorName(doctorMasterDtl.get().getDoctorName());
			}
			if(doctorAppointment.getPatientStatus().equalsIgnoreCase("A")){
				doctorAppointmentDetails.setAppointmentStatus("Appointed");
			}
			else if(doctorAppointment.getPatientStatus().equalsIgnoreCase("P")){
				doctorAppointmentDetails.setAppointmentStatus("Prescribed");
				Optional<Prescription> prescriptionDtl = prescriptionService.findByDoctorAppointmentId(doctorAppointment.getDoctorAppointmentId());
				if(prescriptionDtl.isPresent()){
					Optional<DiseaseMaster> dieseaseMasterDtl = diseaseMasterService.findById(prescriptionDtl.get().getDiseaseId());
					Optional<MedicineMaster> medicinemasterDtl = medicineMasterService.findById((prescriptionDtl.get().getMedicineId()));
					if(dieseaseMasterDtl.isPresent()){
						doctorAppointmentDetails.setDiseaseName(dieseaseMasterDtl.get().getDiseaseName());
					}
					if(medicinemasterDtl.isPresent()){
						doctorAppointmentDetails.setMedicineName(medicinemasterDtl.get().getMedicineName());
					}

				}

			}
			doctorAppointmentDtls.add(doctorAppointmentDetails);
		}
		if (!doctorAppointmentDtls.isEmpty()) {
			return new ResponseEntity<>(doctorAppointmentDtls, HttpStatus.OK);
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
	@GetMapping("/gereratePDF/{doctorAppId}")
	public void gereratePDFPrescription(HttpServletResponse response, @PathVariable long doctorAppId) throws ParseException, DocumentException, IOException {
		response.setContentType("application/pdf");
		Optional<DoctorAppointment> doctorAppointmentDtls = doctorAppointmentService.findById(doctorAppId);
		if (doctorAppointmentDtls.isPresent()){
			DoctorAppointment doctorAppointment = doctorAppointmentDtls.get();
			DoctorAppointmentDetails doctorAppointmentDetails = new DoctorAppointmentDetails();
			SimpleDateFormat sm = new SimpleDateFormat("dd-MM-yyyy");
			String strDate = sm.format(doctorAppointment.getDateOfAppointment());
			doctorAppointmentDetails.setDoctorAppointmentId(doctorAppointment.getDoctorAppointmentId());
			doctorAppointmentDetails.setStrDateOfAppointment(strDate);
			doctorAppointmentDetails.setPatientName(doctorAppointment.getPatientName());
			Optional<DoctorMaster> doctorMasterDtl = doctorMasterService.findById(doctorAppointment.getDoctorId());
			if(doctorMasterDtl.isPresent())
			{
				doctorAppointmentDetails.setDoctorName(doctorMasterDtl.get().getDoctorName());
			}
			if(doctorAppointment.getPatientStatus().equalsIgnoreCase("A")){
				doctorAppointmentDetails.setAppointmentStatus("Appointed");
			}
			else if(doctorAppointment.getPatientStatus().equalsIgnoreCase("P")){
				doctorAppointmentDetails.setAppointmentStatus("Prescribed");
				Optional<Prescription> prescriptionDtl = prescriptionService.findByDoctorAppointmentId(doctorAppointment.getDoctorAppointmentId());
				if(prescriptionDtl.isPresent()){
					doctorAppointmentDetails.setPrescription(prescriptionDtl.get().getPrescription());
					Optional<DiseaseMaster> dieseaseMasterDtl = diseaseMasterService.findById(prescriptionDtl.get().getDiseaseId());
					Optional<MedicineMaster> medicinemasterDtl = medicineMasterService.findById((prescriptionDtl.get().getMedicineId()));
					if(dieseaseMasterDtl.isPresent()){
						doctorAppointmentDetails.setDiseaseName(dieseaseMasterDtl.get().getDiseaseName());
					}
					if(medicinemasterDtl.isPresent()){
						doctorAppointmentDetails.setMedicineName(medicinemasterDtl.get().getMedicineName());
					}

				}

			}
			response.setContentType("application/pdf");
			DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
			String currentDateTime = dateFormatter.format(new Date());

			String headerKey = "Prescription Details";
			String headerValue = "attachment; filename=prescription_" + currentDateTime + ".pdf";
			response.setHeader(headerKey, headerValue);
			UserPDFExporter exporter = new UserPDFExporter(doctorAppointmentDetails);
			exporter.export(response);
		}

	}
}
