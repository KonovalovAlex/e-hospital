package kz.astonline.ehospital.controller;

import kz.astonline.ehospital.model.Card;
import kz.astonline.ehospital.model.Patient;
import kz.astonline.ehospital.service.PatientService;
import kz.astonline.ehospital.spring.scope.SpringViewScoped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Controller
@SpringViewScoped
public class PatientController {

    @Autowired
    private PatientService patientService;
    private Patient patient = new Patient();
    private List <Patient> patients = new ArrayList<>();

    public List<Patient> findPatient() {
        patients.clear();
        patients.add(patientService.findPatientByFullName(patient.getName(), patient.getSurName()));
        return patients;
    }

    public void saveOrUpdatePatient(Patient patient) {
        patientService.saveOrUpdate(this.patient);
    }

    public void deletePatient() {
        patientService.delete(patient.getId());
    }

    @Transactional
    public void registrPatient() {
//        createNewCardForpatient();
        patientService.saveOrUpdate(this.patient);
        patientService.findPatientByFullName(patient.getName(),patient.getSurName());
        this.patient = new Patient();
    }

    private void createNewCardForpatient(){
        Card card = new Card();
        card.setRecord("");
        List<Card> cardList = new ArrayList<>();
        cardList.add(card);
        patient.setCard(cardList);
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
}
