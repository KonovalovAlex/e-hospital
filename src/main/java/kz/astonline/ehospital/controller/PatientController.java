package kz.astonline.ehospital.controller;

import kz.astonline.ehospital.enumiration.employee.SpecializationEnum;
import kz.astonline.ehospital.model.Card;
import kz.astonline.ehospital.model.Employee;
import kz.astonline.ehospital.model.Patient;
import kz.astonline.ehospital.service.AnalysisService;
import kz.astonline.ehospital.service.CardService;
import kz.astonline.ehospital.service.EmployeeService;
import kz.astonline.ehospital.service.PatientService;
import kz.astonline.ehospital.spring.scope.SpringViewScoped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Controller
@SpringViewScoped
public class PatientController implements Serializable {

    @Autowired
    private PatientService patientService;
    @Autowired
    private EmployeeService employeeService;
    private Patient patient = new Patient();
    private List<Patient> patients = new ArrayList<>();
    @Autowired
    private CardService cardService;
    @Autowired
    private AnalysisService analysisService;
    private List<Employee> employees = new LinkedList<>();
    private long employeeId;

    public List<Patient> findPatientWithOpeningCard() {
        patients.clear();
        patients.addAll(patientService.findByFullNameAndOpeningCard(patient.getName(), patient.getSurName(), true));
        return patients;
    }


    public List<Patient> findPatient() {
        patients.clear();
        patients.addAll(patientService.findPatientByFullName(patient.getName(), patient.getSurName()));
        return patients;
    }

    public List<Patient> obtainAllPatientsBelongToEmpl() {
        patients.clear();
        patients.addAll(patientService.findAllBelongToEmp(employeeService.getUserId()));
        return patients;
    }

    public List<Patient> obtainNotExamined() {
        patients.clear();
        patients.addAll(patientService.notExaminedTherapist(employeeService.getUserId()));
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
        for (Employee employee : employees) {
            if (employee.getId() == employeeId) {
                patient.setInClinic(true);
                patient.setPlace("зарегестрирован в "+ LocalDateTime.now().toString()+ " и находится на очереди к терапевту -" +
                        " "+employee.getFirstName()+ " " + employee.getLastName());

                patient.setExamination(false);
                patient.setEmployee(employee);
                break;
            }
        }
        patientService.saveOrUpdate(patient);
        this.patient = new Patient();
    }

    public List<Employee> findFreeTherapist() {
        employees = new LinkedList<>(employeeService.findBySpecialization(SpecializationEnum.THERAPIST));
        return employees;
    }

    public PatientController() {
    }

    public EmployeeService getEmployeeService() {
        return employeeService;
    }

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
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


    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }
}
