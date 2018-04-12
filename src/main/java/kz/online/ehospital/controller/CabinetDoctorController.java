package kz.online.ehospital.controller;


import kz.online.ehospital.model.Analysis;
import kz.online.ehospital.model.Card;
import kz.online.ehospital.model.Employee;
import kz.online.ehospital.model.Patient;
import kz.online.ehospital.service.AnalysisService;
import kz.online.ehospital.service.CardService;
import kz.online.ehospital.service.EmployeeService;
import kz.online.ehospital.service.PatientService;
import kz.online.ehospital.spring.scope.SpringViewScoped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
@SpringViewScoped
@Controller
public class CabinetDoctorController {
    @Autowired
    private PatientService patientService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private CardService cardService;
    @Autowired
    private AnalysisService analysisService;
    private List<Employee> employees = new LinkedList<>();
    private Patient patient = new Patient();
    private List<Patient> patients = new ArrayList<>();
    private long employeeId;
    private List<Card> cards = new LinkedList<>();
    private Analysis analysis = new Analysis();

    public List<Patient> obtainNotExamined() {
        patients.clear();
        patients.addAll(patientService.notExaminedTherapist(employeeService.getUserId()));
        return patients;
    }

    public void acceptPatient(long id) {
        cards.clear();
        List<Patient> patients = new LinkedList<>(getPatients());
        for (Patient patient : patients) {
            if (patient.getId() == id) {
                this.patient = patient;
                break;
            }
        }
        cards.addAll(cardService.getCardsByIdPatient(id,true));

//        try {
//            FacesContext.getCurrentInstance().getExternalContext().redirect("cardOfClient.xhtml"+"?patientId=" + patient.getId());
//        } catch (IOException e) {
//            String errorMessage = "some.problem";
//            FacesContext.getCurrentInstance().addMessage("some.problem", new FacesMessage(errorMessage, errorMessage));
//        }
    }
    public void createRout(){
        System.out.println(patient);
    }

    public Analysis getAnalysis() {
        return analysis;
    }

    public void setAnalysis(Analysis analysis) {
        this.analysis = analysis;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public PatientService getPatientService() {
        return patientService;
    }

    public void setPatientService(PatientService patientService) {
        this.patientService = patientService;
    }

    public EmployeeService getEmployeeService() {
        return employeeService;
    }

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
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

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public CabinetDoctorController() {
    }
}
