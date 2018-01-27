package kz.astonline.ehospital.model;

import kz.astonline.ehospital.model.base.BaseEntity;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by Alex on 12.01.2018.
 */
@Entity
@Table(name = "Form")
public class Form extends BaseEntity {

    @ManyToOne @JoinColumn (name = "employee_id", referencedColumnName = "id")
    private Employee employee;


    @ManyToOne @JoinColumn (name = "type_form_id",referencedColumnName = "id")
    private TypeForm typeForm;
    private String rationale;

    public TypeForm getTypeForm() {
        return typeForm;
    }

    public void setTypeForm(TypeForm typeForm) {
        this.typeForm = typeForm;
    }

    public String getRationale() {
        return rationale;
    }

    public void setRationale(String rationale) {
        this.rationale = rationale;
    }
}
