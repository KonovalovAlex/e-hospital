package kz.online.ehospital.model;

import kz.online.ehospital.model.base.BaseEntity;
import kz.online.ehospital.model.base.BaseEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "PATIENTS")
public class Patient extends BaseEntity {
    @Column(name = "NAME")
    private String name;

    @Column(name = "SURNAME")
    private String surName;

    @OneToMany(mappedBy = "patient",cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
    private List<Card> card;
    @Column
    private String address;
    @Column
    private String place;
    @ManyToOne
    private Department department;

    @ManyToOne (cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id",referencedColumnName = "id")
    private Employee employee;
    @Column
    private Boolean inClinic;
    @Column
    private Boolean examination;

    public Patient() {
    }

    public boolean isExamination() {
        return examination;
    }

    public void setExamination(boolean examined) {
        this.examination = examined;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public List<Card> getCard() {
        return card;
    }

    public void setCard(List<Card> card) {
        this.card = card;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public boolean isInClinic() {
        return inClinic;
    }

    public void setInClinic(boolean inClinic) {
        this.inClinic = inClinic;
    }
}


