package kz.astonline.ehospital.model;

import kz.astonline.ehospital.model.base.BaseEntity;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;

@Entity @DynamicUpdate @DynamicInsert
@Table(name = "CARDS")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Card extends BaseEntity {

    @ManyToOne @JoinColumn (name = "client_id",referencedColumnName = "id")
    private Patient patient;

    @Column
    private String record;

    @OneToMany
    private List<Form> listForm;


    public List<Form> getListForm() {
        return listForm;
    }

    public void setListForm(List<Form> listForm) {
        this.listForm = listForm;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Card() {
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }
}
