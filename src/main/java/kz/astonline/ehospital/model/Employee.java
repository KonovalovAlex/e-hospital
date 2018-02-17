package kz.astonline.ehospital.model;


import kz.astonline.ehospital.enumiration.employee.SpecializationEnum;
import kz.astonline.ehospital.model.base.BaseEntity;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "EMPLOYEE")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Employee extends BaseEntity {


    @Column(name = "register_date")
    private LocalDate registerDate;
    @Column(name = "LASTNAME")
    @Size(min = 2, max = 20)
    private String lastName = "";
    @Column(name = "FIRSTNAME")
    @Size(min = 2, max = 20)
    private String firstName = "";
    @Column(name = "PATRONYMIC")
    private String patronymic = "";
    @Column(name = "BIRTHDAY")
    private LocalDate birthday;
    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "iin")
    private String iin;
    @Column(name = "LOGIN")
    private String login;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "TELEPHONE")
    private String telephone;
    private String keyToObtainDrugs;

    @ManyToMany
    @JoinTable(name = "EMPLOYEE_ROLE", joinColumns = {@JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "ID")
    }, inverseJoinColumns = {@JoinColumn(name = "ROLE_ID", referencedColumnName = "ID")})
    @LazyCollection(LazyCollectionOption.FALSE)
    @Fetch(FetchMode.SUBSELECT)
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    private List<Role> roles;


    @ManyToOne
    @JoinColumn(name = "DEPARTMENT_ID", referencedColumnName = "ID")
    private Department department;

    @Column(name = "ENABLED")
    private boolean enabled;

    @Column(name = "SPECIALIZATION")
//    @Enumerated(EnumType.STRING)
    private SpecializationEnum specializationEnum;


    @Column(length = 5000)
    private String signature;


    public Employee() {
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastname) {
        this.lastName = lastname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstname) {
        this.firstName = firstname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getFullName() {
        return lastName + " " + firstName + " " + patronymic;
    }

    public SpecializationEnum getSpecializationEnum() {
        return specializationEnum;
    }

    public void setSpecializationEnum(SpecializationEnum specializationEnum) {
        this.specializationEnum = specializationEnum;
    }

    public String getIin() {
        return iin;
    }

    public void setIin(String iin) {
        this.iin = iin;
    }

    public LocalDate getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDate registerDate) {
        this.registerDate = registerDate;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getKeyToObtainDrugs() {
        return keyToObtainDrugs;
    }

    public void setKeyToObtainDrugs(String keyToObtainDrugs) {
        this.keyToObtainDrugs = keyToObtainDrugs;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "registerDate=" + registerDate +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +

                ", iin='" + iin + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", roles=" + roles +
                ", department=" + department +

                ", enabled=" + enabled +
                ", specializationEnum=" + specializationEnum +
                '}';
    }

}
