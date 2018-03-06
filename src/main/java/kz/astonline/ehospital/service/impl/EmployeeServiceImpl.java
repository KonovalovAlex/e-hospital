package kz.astonline.ehospital.service.impl;

import kz.astonline.ehospital.enumiration.employee.SpecializationEnum;
import kz.astonline.ehospital.model.Department;
import kz.astonline.ehospital.model.Employee;

import kz.astonline.ehospital.model.Role;

import kz.astonline.ehospital.repository.EmployeeRepository;
import kz.astonline.ehospital.repository.RoleRepository;
import kz.astonline.ehospital.service.EmployeeService;
import kz.astonline.ehospital.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private RoleService roleService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Employee saveOrUpdate(Employee entity) {
        return employeeRepository.save(entity);
    }


    @Override
    public Employee findById(Long id) {
        return employeeRepository.findOne(id);
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findByLogin(String login) {
        return employeeRepository.findByLogin(login);
    }

    @Override
    public Employee findByFullName(String firstname, String lastname, String patronymic) {
        return employeeRepository.findByFullName(firstname, lastname, patronymic);
    }

    @Override
    public Employee findByIIN(String iin) {
        return employeeRepository.findByIIN(iin);
    }

    @Override
    public Employee findCurrentEmployee() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && !(authentication instanceof AnonymousAuthenticationToken) && authentication.isAuthenticated()) {
            UserDetails details = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (details != null) {
                String username = details.getUsername();
                return findByLogin(username);
            }
        }
        return null;
    }

    @Override
    public List<Employee> getAllEnabledOrDisabledEmployee(Boolean enabled) {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> getEmployeesBySpecializationAndDepartment(SpecializationEnum spec, Department department) {
        return employeeRepository.getEmployeesBySpecializationAndDepartment(spec,department);
    }

    @Override
    public List<Employee> findBySpecialization(SpecializationEnum specializationEnum) {
        return employeeRepository.findBySpecialization(specializationEnum);
    }

    @Override
    public List<Employee> findByRole(String role) {
        Role finderRole = roleRepository.findByRoleName(role);
        return employeeRepository.findByRole(finderRole);
    }

    @Override
    public List<Employee> findByRoleForDepartment(String role, Department department) {
        Role finderRole = roleRepository.findByRoleName(role);
        return employeeRepository.findByRoleForDepartment(finderRole, department);
    }



    @Override
    public List<Employee> getByDepartment(Department department) {
        return employeeRepository.getByDepartment(department);
    }

    @Override
    public List<Employee> getByDepartmentOnlyDoctors(Department department) {
        return employeeRepository.getByDepartmentOnlyDoctors(department);
    }

    public Long getUserId(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String employeeName = authentication.getName();
        long id = employeeRepository.findByLogin(employeeName).getId();
        return id;
    }

    @Override
    public void registrateEmpl(Employee employee, Department department, String storeIdDepartment ) {
        department.setId(Long.parseLong(storeIdDepartment));
        employee.setEnabled(true);
        employee.setDepartment(department);
        employee.setRegisterDate(LocalDate.now());
        employee.setPassword(bCryptPasswordEncoder.encode(employee.getPassword()));
        saveOrUpdate(employee);
    }
}
