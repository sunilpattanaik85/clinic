package com.clinicexa.clinic.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class DoctorMaster {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long doctorId;
	@Column(unique = true)
	private String doctorName;
	@Column(unique = true)
	private String doctorPhone;
	@Column(unique = true)
	private String doctorEmail;
	@JsonCreator
	public DoctorMaster(@JsonProperty("doctorName") String doctorName,@JsonProperty("doctorPhone") String doctorPhone,@JsonProperty("doctorEmail") String doctorEmail) {
		super();
		this.doctorName = doctorName;
		this.doctorPhone = doctorPhone;
		this.doctorEmail = doctorEmail;
	}
	public DoctorMaster() {
		
	}
	public Long getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getDoctorPhone() {
		return doctorPhone;
	}
	public void setDoctorPhone(String doctorPhone) {
		this.doctorPhone = doctorPhone;
	}
	public String getDoctorEmail() {
		return doctorEmail;
	}
	public void setDoctorEmail(String doctorEmail) {
		this.doctorEmail = doctorEmail;
	}
	@Override
	public String toString() {
		return "DoctorMaster [doctorId=" + doctorId + ", doctorName=" + doctorName + ", doctorPhone=" + doctorPhone
				+ ", doctorEmail=" + doctorEmail + "]";
	}

}
