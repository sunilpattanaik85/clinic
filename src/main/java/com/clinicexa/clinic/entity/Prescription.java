package com.clinicexa.clinic.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Prescription {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long slNo; 
	private Long doctorAppointmentId; 
	private Long diseaseId;
	private Long medicineId; 
	private String prescription;
	@JsonCreator
	public Prescription(@JsonProperty("doctorAppointmentId") Long doctorAppointmentId,@JsonProperty("diseaseId") Long diseaseId,@JsonProperty("medicineId") Long medicineId,@JsonProperty("prescription") String prescription) {
		super();
		this.doctorAppointmentId = doctorAppointmentId;
		this.diseaseId = diseaseId;
		this.medicineId = medicineId;
		this.prescription = prescription;
	}
	public Prescription() {
		
	}
	public Long getSlNo() {
		return slNo;
	}
	public void setSlNo(Long slNo) {
		this.slNo = slNo;
	}
	public Long getDoctorAppointmentId() {
		return doctorAppointmentId;
	}
	public void setDoctorAppointmentId(Long doctorAppointmentId) {
		this.doctorAppointmentId = doctorAppointmentId;
	}
	public Long getDiseaseId() {
		return diseaseId;
	}
	public void setDiseaseId(Long diseaseId) {
		this.diseaseId = diseaseId;
	}
	public Long getMedicineId() {
		return medicineId;
	}
	public void setMedicineId(Long medicineId) {
		this.medicineId = medicineId;
	}
	public String getPrescription() {
		return prescription;
	}
	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}
	@Override
	public String toString() {
		return "Prescription [slNo=" + slNo + ", doctorAppointmentId=" + doctorAppointmentId + ", diseaseId="
				+ diseaseId + ", medicineId=" + medicineId + ", prescription=" + prescription + "]";
	}
	
	
}
