package com.clinicexa.clinic.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinicexa.clinic.entity.MedicineMaster;

import java.util.List;

@Repository
public interface MedicineMasterRepository extends JpaRepository<MedicineMaster, Long> {
    List<MedicineMaster> findByDiseaseId(Long diseaseId);
}
