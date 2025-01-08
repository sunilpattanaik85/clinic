package com.clinicexa.clinic.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class MedicineMaster {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long medicineId;
	@Column(unique = true)
	private String medicineName;
	private Long diseaseId;
	@JsonCreator
	public MedicineMaster(@JsonProperty("medicineName") String medicineName,@JsonProperty("diseaseId") Long diseaseId) {
		super();
		this.medicineName = medicineName;
		this.diseaseId = diseaseId;
	}
	public MedicineMaster() {
		
	}
	public Long getMedicineId() {
		return medicineId;
	}
	public void setMedicineId(Long medicineId) {
		this.medicineId = medicineId;
	}
	public String getMedicineName() {
		return medicineName;
	}
	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}
	public Long getDiseaseId() {
		return diseaseId;
	}
	public void setDiseaseId(Long diseaseId) {
		this.diseaseId = diseaseId;
	}
	@Override
	public String toString() {
		return "MedicineMaster [medicineId=" + medicineId + ", medicineName=" + medicineName + ", diseaseId="
				+ diseaseId + "]";
	}
	
	
}
