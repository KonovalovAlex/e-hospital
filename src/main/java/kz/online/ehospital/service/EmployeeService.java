package kz.online.ehospital.service;

import kz.online.ehospital.enumiration.employee.SpecializationEnum;
import kz.online.ehospital.model.Department;
import kz.online.ehospital.model.Employee;

import kz.online.ehospital.service.base.BaseService;
import kz.online.ehospital.enumiration.employee.SpecializationEnum;
import kz.online.ehospital.service.base.BaseService;

import java.util.List;

public interface EmployeeService extends BaseService<Employee,Long> {

    Employee findByLogin(String login);

    Employee findByFullName(String firstname, String lastname, String patronymic);

    Employee findByIIN(String iin);

    Employee findCurrentEmployee();

    List<Employee> getAllEnabledOrDisabledEmployee(Boolean enabled);

    List<Employee> getEmployeesBySpecializationAndDepartment(SpecializationEnum spec, Department department);

    List<Employee> findBySpecialization(SpecializationEnum specializationEnum);

    List<Employee> findByRole(String role);

    List<Employee> findByRoleForDepartment(String role, Department department);
    void registrateEmpl(Employee employee, Department department, String idDepartment);
    List<Employee> getByDepartment(Department department);
    List<Employee> getByDepartmentOnlyDoctors(Department department);
    Long getUserId();


}
