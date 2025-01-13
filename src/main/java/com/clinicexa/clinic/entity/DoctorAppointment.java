package com.clinicexa.clinic.entity;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class DoctorAppointment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long doctorAppointmentId; 
	private Long doctorId;
	@Column(unique = true)
	private String patientName; 
	@Column(unique = true)
	private String patientPhone; 
	private Date dateOfAppointment; 
	private String patientStatus;
	@Transient
	private String strDateOfAppointment;

	public String getStrDateOfAppointment() {
		return strDateOfAppointment;
	}

	public void setStrDateOfAppointment(String strDateOfAppointment) {
		this.strDateOfAppointment = strDateOfAppointment;
	}

	@JsonCreator
	public DoctorAppointment(@JsonProperty("doctorId") Long doctorId,@JsonProperty("patientName") String patientName,@JsonProperty("patientPhone") String patientPhone,@JsonProperty("dateOfAppointment") Date dateOfAppointment,
			@JsonProperty("patientStatus") String patientStatus) {
		super();
		this.doctorId = doctorId;
		this.patientName = patientName;
		this.patientPhone = patientPhone;
		this.dateOfAppointment = dateOfAppointment;
		this.patientStatus = patientStatus;
	}
	public DoctorAppointment() {
		
	}
	public Long getDoctorAppointmentId() {
		return doctorAppointmentId;
	}
	public void setDoctorAppointmentId(Long doctorAppointmentId) {
		this.doctorAppointmentId = doctorAppointmentId;
	}
	public Long getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getPatientPhone() {
		return patientPhone;
	}
	public void setPatientPhone(String patientPhone) {
		this.patientPhone = patientPhone;
	}
	public Date getDateOfAppointment() {
		return dateOfAppointment;
	}
	public void setDateOfAppointment(Date dateOfAppointment) {
		this.dateOfAppointment = dateOfAppointment;
	}
	public String getPatientStatus() {
		return patientStatus;
	}
	public void setPatientStatus(String patientStatus) {
		this.patientStatus = patientStatus;
	}
	@Override
	public String toString() {
		return "DoctorAppointment [doctorAppointmentId=" + doctorAppointmentId + ", doctorId=" + doctorId
				+ ", patientName=" + patientName + ", patientPhone=" + patientPhone + ", dateOfAppointment="
				+ dateOfAppointment + ", patientStatus=" + patientStatus + "]";
	}
}
