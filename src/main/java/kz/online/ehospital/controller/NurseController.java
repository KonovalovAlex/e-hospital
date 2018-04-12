package kz.online.ehospital.controller;

import kz.online.ehospital.enumiration.employee.SpecializationEnum;
import kz.online.ehospital.model.Card;
import kz.online.ehospital.model.Employee;
import kz.online.ehospital.model.Patient;
import kz.online.ehospital.service.CardService;
import kz.online.ehospital.service.EmployeeService;
import kz.online.ehospital.service.PatientService;
import kz.online.ehospital.spring.scope.SpringViewScoped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@SpringViewScoped
@Controller
public class NurseController {
    @Autowired
    private PatientService patientService;
    @Autowired
    private EmployeeService employeeService;
    private Patient patient = new Patient();
    private List<Patient> patients = new ArrayList<>();
    @Autowired
    private CardService cardService;
    private List<Employee> employees = new LinkedList<>();
    private long employeeId;

    @Transactional
    public void registrPatient() {
        cardService.initCard(patient);
        for (Employee employee : employees) {
            if (employee.getId() == employeeId) {
                patient.setInClinic(true);
                patient.setPlace("записан к терапевту" + employee.getFirstName() + " "
                        + employee.getLastName() + "время: " + patient.getPlace());
                patient.setExamination(false);
                patient.setEmployee(employee);
                break;
            }
        }
        patientService.saveOrUpdate(patient);
        this.patient = new Patient();
    }

    public List<Patient> findPatient() {
        patients.clear();
        patients.addAll(patientService.findPatientByFullName(patient.getName(), patient.getSurName()));
        return patients;
    }

    public void saveOrUpdatePatient(Patient patient) {
        patientService.saveOrUpdate(patient);
    }

    public List<Employee> findFreeTherapist() {
        employees = new LinkedList<>(employeeService.findBySpecialization(SpecializationEnum.THERAPIST));
        return employees;
    }

    public void createNewCard(Patient patient) {
        Card card = new Card();
        card.setActive(true);
        card.setPatient(patient);
        List<Card> cards = new ArrayList<>();
        cards.add(card);
        patient.setCard(cards);
        patientService.saveOrUpdate(patient);
    }

    public NurseController() {
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
}
