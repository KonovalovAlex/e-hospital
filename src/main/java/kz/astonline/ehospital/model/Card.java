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
    private boolean examinedByTherapist;
    @Column
    private boolean isActive;

    @OneToMany(mappedBy = "card",cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
    private List<Analysis> analyzes;

    @Transient
    private boolean editable;


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

    public void setExaminedByTherapist(boolean examinedByTherapist) {
        this.examinedByTherapist = examinedByTherapist;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
