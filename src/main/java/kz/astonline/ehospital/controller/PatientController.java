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
    private List <Patient> list = new ArrayList();

    public List<Patient> findPatient() {
        list.clear();
        list.add(patientService.findPatientFullName(patient.getName(), patient.getSurName()));
        return list;
    }

    public void saveOrUpdatePatient() {
        patientService.saveOrUpdate(this.patient);
    }

    public void deletePatient() {
        patientService.delete(patient.getId());
    }

    public void registrPatient() {
        patientService.saveOrUpdate(this.patient);
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

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }
}
