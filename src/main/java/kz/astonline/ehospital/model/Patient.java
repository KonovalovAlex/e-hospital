package kz.astonline.ehospital.model;

import kz.astonline.ehospital.model.base.BaseEntity;

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

    @ManyToOne
    private Department department;
    @Column
    private String therapist;
    @Column
    private boolean inClinic = true;

    public String getTherapist() {
        return therapist;
    }

    public void setTherapist(String therapist) {
        this.therapist = therapist;
    }

    public boolean isInClinic() {
        return inClinic;
    }

    public void setInClinic(boolean beInClinic) {
        this.inClinic = beInClinic;
    }


    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public Patient() {
    }
}


