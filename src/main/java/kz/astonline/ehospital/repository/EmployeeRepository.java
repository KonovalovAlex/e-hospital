package kz.astonline.ehospital.repository;

import kz.astonline.ehospital.enumiration.employee.SpecializationEnum;
import kz.astonline.ehospital.model.Department;
import kz.astonline.ehospital.model.Employee;

import kz.astonline.ehospital.model.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;

import javax.persistence.QueryHint;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    @QueryHints({@QueryHint(name="org.hibernate.cacheable", value="true")})
    @Query("SELECT employee from Employee employee inner join fetch employee.department where employee.login=:login")
    Employee findByLogin(@Param("login")String login);

    @QueryHints({@QueryHint(name="org.hibernate.cacheable", value="true")})
    @Query("SELECT employee from Employee employee inner join fetch employee.department where " +
            "employee.firstName=:firstName and employee.lastName=:lastName and employee.patronymic=:patronymic")
    Employee findByFullName(@Param("firstName")String firstName, @Param("lastName")String lastName, @Param("patronymic")String patronymic);

    @QueryHints({@QueryHint(name="org.hibernate.cacheable", value="true")})
    @Query("SELECT employee from Employee employee inner join fetch employee.department where employee.iin=:iin")
    Employee findByIIN(@Param("iin")String iin);


    @QueryHints({@QueryHint(name="org.hibernate.cacheable", value="true")})
    @Query("select e from Employee e where e.specializationEnum = :specialization and e.department = :department and e.enabled=true")
    List<Employee> getEmployeesBySpecializationAndDepartment(@Param("specialization")SpecializationEnum spec,@Param("department")Department department);


    @QueryHints({@QueryHint(name="org.hibernate.cacheable", value="true")})
    @Query("select e from Employee e where e.specializationEnum = :spec and e.enabled = true")
    List<Employee> findBySpecialization(@Param("spec") SpecializationEnum specializationEnum);


    @QueryHints({@QueryHint(name="org.hibernate.cacheable", value="true")})
    @Query("select e from Employee e join e.roles r where r=:role")
    List<Employee> findByRole(@Param("role") Role role);


    @QueryHints({@QueryHint(name="org.hibernate.cacheable", value="true")})
    @Query("select e from Employee e join e.roles r where (r=:role) and (e.department = :department)")
    List<Employee> findByRoleForDepartment(@Param("role") Role role, @Param("department")Department department);




    @QueryHints({@QueryHint(name="org.hibernate.cacheable", value="true")})
    @Query("select e from Employee e where e.department = :department")
    List<Employee> getByDepartment(@Param("department") Department department);

    @QueryHints({@QueryHint(name="org.hibernate.cacheable", value="true")})
    @Query("select e from Employee e join e.roles r where (r.role='CHIEF' or r.role='DOCTOR') and e.department = :department")
    List<Employee> getByDepartmentOnlyDoctors(@Param("department") Department department);




}
