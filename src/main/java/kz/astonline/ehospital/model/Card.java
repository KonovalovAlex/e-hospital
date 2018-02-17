package kz.astonline.ehospital.model;


import kz.astonline.ehospital.model.base.BaseEntity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CARDS")
public class Card extends BaseEntity {

    @ManyToOne (cascade = CascadeType.ALL,fetch = FetchType.EAGER) @JoinColumn (name = "patients_id",referencedColumnName = "id")
    private Patient patient;

    @Column (columnDefinition = "TEXT")
    private String record;
    @Column
    private String diagnosis;
    @Column
    private String pills;
    @Column
    private int quantityDays;
    @Column
    private int quantityTimes;
    @Column
    private Boolean examinedByTherapist = false;
    @Column
    private Boolean isActive = true;

    @OneToMany(mappedBy = "card",cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
    private List<Analysis> analyzes;

    @Transient
    private boolean editable;

    public Boolean getExaminedByTherapist() {
        return examinedByTherapist;
    }

    public void setExaminedByTherapist(Boolean examinedByTherapist) {
        this.examinedByTherapist = examinedByTherapist;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public List<Analysis> getAnalyzes() {
        return analyzes;
    }

    public void setAnalyzes(List<Analysis> analyses) {
        this.analyzes = analyses;
    }

    public boolean isEditable() {
        return editable;
    }
    public void setEditable(boolean editable) {
        this.editable = editable;
    }


    public int getQuantityDays() {
        return quantityDays;
    }

    public void setQuantityDays(int quantityDays) {
        this.quantityDays = quantityDays;
    }

    public String getPills() {

        return pills;
    }

    public void setPills(String pills) {
        this.pills = pills;
    }


    public int getQuantityTimes() {
        return quantityTimes;
    }

    public void setQuantityTimes(int quantityTimes) {
        this.quantityTimes = quantityTimes;
    }

    public String getDiagnosis() {
        return diagnosis;
    }


    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }
    //    @OneToMany
//    private List<Form> listForm;

//    public List<Form> getListForm() {
//        return listForm;
//    }
//
//    public void setListForm(List<Form> listForm) {
//        this.listForm = listForm;
//    }

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

    public boolean isExaminedByTherapist() {
        return examinedByTherapist;
    }

    public void setExaminedByTherapist(boolean firstObserv) {
        this.examinedByTherapist = firstObserv;
    }
}
