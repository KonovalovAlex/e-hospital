package kz.astonline.ehospital.controller;

import kz.astonline.ehospital.enumiration.employee.SpecializationEnum;
import kz.astonline.ehospital.model.Card;
import kz.astonline.ehospital.model.Department;
import kz.astonline.ehospital.model.Patient;
import kz.astonline.ehospital.model.Employee;
import kz.astonline.ehospital.service.CardService;
import kz.astonline.ehospital.service.EmployeeService;
import kz.astonline.ehospital.service.PatientService;
import kz.astonline.ehospital.service.RoleService;
import kz.astonline.ehospital.spring.scope.SpringViewScoped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Controller
@SpringViewScoped
public class EmployeeController implements Serializable {

    private Employee employee = new Employee();
    private List<Card> cards = new LinkedList<>();
    private Card card = new Card();
    private Patient patient = new Patient();
    private List<Employee> list = new ArrayList<>();
    private Department department = new Department();
    private String storeIdDepartment;
    @Autowired
    private PatientController patientController;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private CardService cardService;
    @Autowired
    private RoleService roleService;

    @Autowired
    private PatientService patientService;

    private List<SpecializationEnum> items = Arrays.asList(SpecializationEnum.class.getEnumConstants());


    public void registr() {
        employeeService.registrateEmpl(employee, department, storeIdDepartment);
    }

    public void acceptPatient(long id) {
        cards.clear();
        List<Patient> patients = new LinkedList<>(patientController.getPatients());
        for (Patient patient : patients) {
            if (patient.getId() == id) {
                this.patient = patient;
                break;
            }
        }
        cards.addAll(cardService.getCardsByIdPatinet(id));
        try {
            FacesContext.getCurrentInstance().getExternalContext().
                    redirect("cardOfClient.xhtml?id=\" + " + patient.getId());
        } catch (IOException e) {
            String errorMessage = "some.problem";
            FacesContext.getCurrentInstance().addMessage("some.problem", new FacesMessage(errorMessage, errorMessage));
        }
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setItems(List<SpecializationEnum> items) {
        this.items = items;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public kz.astonline.ehospital.controller.PatientController getPatientController() {
        return patientController;
    }

    public void setPatientController(kz.astonline.ehospital.controller.PatientController patientController) {
        patientController = patientController;
    }

    public String getStoreIdDepartment() {
        return storeIdDepartment;
    }

    public void setStoreIdDepartment(String storeIdDepartment) {
        this.storeIdDepartment = storeIdDepartment;
    }

    public List<Patient> getAllPatients() {
        return patientService.findAll();
    }

    public EmployeeController() {
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public List<Employee> getList() {
        return list;
    }

    public void setList(List<Employee> list) {
        this.list = list;
    }

    public EmployeeService getEmployeeService() {
        return employeeService;
    }

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public CardService getCardService() {
        return cardService;
    }

    public void setCardService(CardService cardService) {
        this.cardService = cardService;
    }

    public RoleService getRoleService() {
        return roleService;
    }

    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    public List<SpecializationEnum> getItems() {
        return items;
    }


    public PatientService getPatientService() {
        return patientService;
    }

    public void setPatientService(PatientService patientService) {
        this.patientService = patientService;
    }
}
