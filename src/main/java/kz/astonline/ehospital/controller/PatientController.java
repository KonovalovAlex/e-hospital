package kz.astonline.ehospital.controller;

import kz.astonline.ehospital.model.Patient;
import kz.astonline.ehospital.service.PatientService;
import kz.astonline.ehospital.spring.scope.SpringViewScoped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
@SpringViewScoped
public class PatientController {

    @Autowired
    private PatientService patientService;
    private Patient patient = new Patient();
    private List list = new ArrayList();

    public List<Patient> findPatient() {
        list.clear();
        list.add(patientService.findPatientFullName(patient.getName(), patient.getSurName()));
        if (list != null) return list;
        return null;
    }

    public void registrPatient(){

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

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }
}
