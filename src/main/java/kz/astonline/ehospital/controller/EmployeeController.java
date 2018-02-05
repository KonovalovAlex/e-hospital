package kz.astonline.ehospital.controller;

import kz.astonline.ehospital.enumiration.employee.SpecializationEnum;
import kz.astonline.ehospital.model.Card;
import kz.astonline.ehospital.model.Patient;
import kz.astonline.ehospital.model.Employee;
import kz.astonline.ehospital.model.Role;
import kz.astonline.ehospital.service.CardService;
import kz.astonline.ehospital.service.EmployeeService;
import kz.astonline.ehospital.service.PatientService;
import kz.astonline.ehospital.service.RoleService;
import kz.astonline.ehospital.spring.scope.SpringViewScoped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@SpringViewScoped
public class EmployeeController implements Serializable {

    private Employee employee = new Employee();
    private Card card = new Card();
    private List<Employee> list = new ArrayList<>();

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private CardService cardService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PatientService patientService;

    private List<SpecializationEnum> items = Arrays.asList(SpecializationEnum.class.getEnumConstants());

    @PostConstruct
    public void init() {
        employee.setRegisterDate(LocalDate.now());
        System.out.println(employee.getRegisterDate());
//        System.out.println(employee.set);

    }

    public void registr() {
        employeeService.saveOrUpdate(employee);
    }


    public List<Employee> searchPatient() {
        System.out.println(employee.getIin());
        list.clear();
        list.add(employeeService.findByIIN(employee.getIin()));
        return list;
    }

    public String showOrEditForm() {
        employeeService.findById(employee.getId());
        return"";

    }

    public List<Patient> getAllPatients(){
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

    public void setItems(List<SpecializationEnum> items) {
        this.items = items;
    }

    public PatientService getPatientService() {
        return patientService;
    }

    public void setPatientService(PatientService patientService) {
        this.patientService = patientService;
    }
}
