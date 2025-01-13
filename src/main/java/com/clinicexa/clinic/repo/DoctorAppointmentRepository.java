package com.clinicexa.clinic.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clinicexa.clinic.entity.DoctorAppointment;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DoctorAppointmentRepository extends JpaRepository<DoctorAppointment, Long>{
    @Query(value = "select * from doctor_appointment where patient_status='A' and doctor_id=?1", nativeQuery = true)
    List<DoctorAppointment> findByDoctorId(Long doctorId);
    @Query(value = "select * from doctor_appointment where doctor_id=?1", nativeQuery = true)
    List<DoctorAppointment> findByDoctorIdWithoutStatus(Long doctorId);
    @Query(nativeQuery = true , value="select da.date_of_appointment,dm.doctor_name,da.patient_name,dm2.disease_name,mm.medicine_name,da.patient_status \n" +
            "from doctor_appointment As da join prescription As p on da.doctor_appointment_id = p.doctor_appointment_id\n" +
            "join doctor_master As dm on da.doctor_id = dm.doctor_id\n" +
            "join disease_master As dm2 on p.disease_id = dm2.disease_id\n" +
            "join medicine_master As mm on p.medicine_id = mm.medicine_id\n" +
            "where da.doctor_id =?1\n" +
            "order by da.doctor_appointment_id")
    List<Object[]> fetchAllDADetailsWithPrescription(Long doctorAppId);
}
