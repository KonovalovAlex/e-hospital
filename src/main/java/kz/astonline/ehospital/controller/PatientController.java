package kz.astonline.ehospital.controller;

import kz.astonline.ehospital.model.Patient;
import kz.astonline.ehospital.service.AnalysisService;
import kz.astonline.ehospital.service.CardService;
import kz.astonline.ehospital.service.PatientService;
import kz.astonline.ehospital.spring.scope.SpringViewScoped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Controller
@SpringViewScoped
public class PatientController implements Serializable {

    @Autowired
    private PatientService patientService;
    private Patient patient = new Patient();
    private List<Patient> patients = new ArrayList<>();

    @Autowired
    private CardService cardService;
    @Autowired
    private AnalysisService analysisService;

    public List<Patient> findPatientWithOpeningCard(){
        return patientService.findByFullNameAndOpeningCard(patient.getName(),patient.getSurName(),true);
    }


    public List<Patient> findPatient() {
        patients.clear();
        patients.addAll(patientService.findPatientByFullName(patient.getName(), patient.getSurName()));
        return patients;
    }

    public void saveOrUpdatePatient(Patient patient) {
        patientService.saveOrUpdate(patient);
    }

    public void deletePatient() {
        patientService.delete(patient.getId());
    }

    @Transactional
    public void registrPatient() {
        cardService.initCard(patient);
        this.patient = new Patient();
    }

    public PatientController() {
    }

    public PatientService getPatientService() {
        return patientService;
    }

    public void setPatientService(PatientService patientService) {
        this.patientService = patientService;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    public CardService getCardService() {
        return cardService;
    }

    public void setCardService(CardService cardService) {
        this.cardService = cardService;
    }

    public AnalysisService getAnalysisService() {
        return analysisService;
    }

    public void setAnalysisService(AnalysisService analysisService) {
        this.analysisService = analysisService;
    }
}
