package com.clinicexa.clinic.controller;

import com.clinicexa.clinic.entity.DiseaseMaster;
import com.clinicexa.clinic.entity.DoctorAppointment;
import com.clinicexa.clinic.entity.DoctorMaster;
import com.clinicexa.clinic.entity.Prescription;
import com.clinicexa.clinic.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class ClinicController {
    @Autowired
    private DoctorMasterService doctorMasterService;
    @Autowired
    private DiseaseMasterService diseaseMasterService;
    @Autowired
    private MedicineMasterService medicineMasterService;
    @Autowired
    private DoctorAppointmentService doctorAppointmentService;
    @Autowired
    private PrescriptionService prescriptionService;
    @GetMapping("/clinic")
    public String fetchAllDoctorsWithDiseases(@ModelAttribute DoctorMaster doctorMaster, @ModelAttribute DiseaseMaster diseaseMaster, BindingResult bindingResult, Model model) {
        List<DoctorMaster> doctorsList =  doctorMasterService.findAll();
        model.addAttribute("doctorsList", doctorsList);
        List<DiseaseMaster> diseaseList = diseaseMasterService.findAll();
        model.addAttribute("diseaseList", diseaseList);
        return "clinic";
    }
    @PostMapping("/clinic/save")
    public String saveClinicData(@RequestParam("doctorId") Long doctorId, @RequestParam("doctorAppId") Long doctorAppId, @RequestParam("diseaseId") Long diseaseId, @RequestParam("medicineId") Long medicineId, @RequestParam("prescriptionId") String prescriptionId, RedirectAttributes redirectAttributes){
        Optional<DoctorAppointment> doctorApp = doctorAppointmentService.findById(doctorAppId);
        if(doctorApp.isPresent()){
            DoctorAppointment doctorAppointment = doctorApp.get();
            doctorAppointment.setPatientStatus("P");
            //doctorAppointmentService.saveDoctorAppointment(doctorAppointment);
            Prescription prescription = new Prescription(doctorAppId,diseaseId,medicineId,prescriptionId);
           // prescriptionService.savePrescription(prescription);
            redirectAttributes.addFlashAttribute("message", "Record has been saved successfully!");
        }
        return "redirect:/clinic";
    }
}
