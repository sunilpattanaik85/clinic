package com.clinicexa.clinic.dto;

public class DoctorAppointmentDetails {
    private String strDateOfAppointment;
    private String doctorName;
    private String patientName;
    private String diseaseName;
    private String medicineName;
    private String appointmentStatus;
    private Long doctorAppointmentId;
    private String prescription;

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public Long getDoctorAppointmentId() {
        return doctorAppointmentId;
    }

    public void setDoctorAppointmentId(Long doctorAppointmentId) {
        this.doctorAppointmentId = doctorAppointmentId;
    }

    public String getStrDateOfAppointment() {
        return strDateOfAppointment;
    }

    public void setStrDateOfAppointment(String strDateOfAppointment) {
        this.strDateOfAppointment = strDateOfAppointment;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getAppointmentStatus() {
        return appointmentStatus;
    }

    public void setAppointmentStatus(String appointmentStatus) {
        this.appointmentStatus = appointmentStatus;
    }

    @Override
    public String toString() {
        return "DoctorAppointmentDetails{" +
                "strDateOfAppointment='" + strDateOfAppointment + '\'' +
                ", doctorName='" + doctorName + '\'' +
                ", patientName='" + patientName + '\'' +
                ", diseaseName='" + diseaseName + '\'' +
                ", medicineName='" + medicineName + '\'' +
                ", appointmentStatus='" + appointmentStatus + '\'' +
                ", doctorAppointmentId=" + doctorAppointmentId +
                ", prescription='" + prescription + '\'' +
                '}';
    }
}
