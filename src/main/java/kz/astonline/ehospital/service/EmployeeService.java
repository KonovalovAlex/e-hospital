package kz.astonline.ehospital.service;

import kz.astonline.ehospital.enumiration.employee.SpecializationEnum;
import kz.astonline.ehospital.model.Department;
import kz.astonline.ehospital.model.Employee;

import kz.astonline.ehospital.service.base.BaseService;

import java.util.List;

public interface EmployeeService extends BaseService<Employee,Long> {

    Employee findByLogin(String login);

    Employee findByFullName(String firstname, String lastname, String patronymic);

    Employee findByIIN(String iin);

    Employee findCurrentEmployee();

    List<Employee> getAllEnabledOrDisabledEmployee(Boolean enabled);

    List<Employee> getEmployeesBySpecializationAndDepartment(SpecializationEnum spec,Department department);

    List<Employee> findBySpecialization(SpecializationEnum specializationEnum);

    List<Employee> findByRole(String role);

    List<Employee> findByRoleForDepartment(String role, Department department);



    List<Employee> getByDepartment(Department department);
    List<Employee> getByDepartmentOnlyDoctors(Department department);



}
