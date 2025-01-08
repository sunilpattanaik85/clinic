package com.clinicexa.clinic.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
@Entity
public class DiseaseMaster {
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private Long diseaseId;
	 @Column(unique = true)
	 private String diseaseName;
	 @JsonCreator
	public DiseaseMaster(@JsonProperty("diseaseName") String diseaseName) {
		this.diseaseName = diseaseName;
	}
	 public DiseaseMaster() {
		 
	 }
	public Long getDiseaseId() {
		return diseaseId;
	}
	public void setDiseaseId(Long diseaseId) {
		this.diseaseId = diseaseId;
	}
	public String getDiseaseName() {
		return diseaseName;
	}
	
	public void setDiseaseName(String diseaseName) {
		this.diseaseName = diseaseName;
	}
	 
	@Override
	public String toString() {
		return "DisaeaseMaster [diseaseId=" + diseaseId + ", diseaseName=" + diseaseName + "]";
	} 

}
