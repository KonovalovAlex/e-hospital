package kz.astonline.ehospital.controller;

import kz.astonline.ehospital.enumiration.employee.SpecializationEnum;
import kz.astonline.ehospital.model.Department;
import kz.astonline.ehospital.model.Employee;
import kz.astonline.ehospital.service.EmployeeService;
import kz.astonline.ehospital.spring.scope.SpringViewScoped;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@SpringViewScoped
public class AdminController implements Serializable {
    private List<Employee> employeeList = new ArrayList<>();
    private Employee employee = new Employee();
    @Autowired
    private EmployeeService employeeService;
    private String name;
    private UIInput emailAddyInputText;
    private Long idHolder;
    private Department department = new Department();
    private String storeIdDepartment;
    private List<SpecializationEnum> items = Arrays.asList(SpecializationEnum.class.getEnumConstants());

    public void registr() {
        employeeService.registrateEmpl(employee, department, storeIdDepartment);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "user_saved", null));
    }

    public void editEmployee() {
        employeeService.saveOrUpdate(employee);
    }

    public void deleteEmployee() {
        employeeService.delete(employee.getId());
    }

    @PostConstruct
    public void initEmployeeList() {
        employeeList.addAll(employeeService.findAll());
    }

    @PostConstruct
    public String obtainName() {
        this.name = SecurityContextHolder.getContext().getAuthentication().getName();
        return name;
    }

    public void onRowSelect(SelectEvent event) {
        System.out.println("Selecting new user...");
        this.employee = (Employee) event.getObject();
        FacesContext context = FacesContext.getCurrentInstance();
        System.out.println("Selected User name: " + this.employee.getFirstName());
        if (this.employee == null) {
            String msg = "No user is selected!!";
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null));
        } else {
            String msg = "A User selected: " + this.employee;
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null));
        }
    }

    public void onRowUnselect(UnselectEvent event) {
        String msg = "User unselected: " + this.employee;
        this.employee = null;
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null));
        if (this.employee == null) {
            System.out.println(this.employee + ": is unselected");
        }
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getStoreIdDepartment() {
        return storeIdDepartment;
    }

    public void setStoreIdDepartment(String storeIdDepartment) {
        this.storeIdDepartment = storeIdDepartment;
    }

    public List<SpecializationEnum> getItems() {
        return items;
    }

    public void setItems(List<SpecializationEnum> items) {
        this.items = items;
    }

    public Long getIdHolder() {
        return idHolder;
    }

    public void setIdHolder(Long idHolder) {
        this.idHolder = idHolder;
    }

    public UIInput getEmailAddyInputText() {
        return emailAddyInputText;
    }

    public void setEmailAddyInputText(UIInput emailAddyInputText) {
        this.emailAddyInputText = emailAddyInputText;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public AdminController() {

    }
}
