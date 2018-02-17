package kz.astonline.ehospital.model;



import kz.astonline.ehospital.model.base.BaseEntity;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;

@Entity @DynamicUpdate @DynamicInsert
@Table(name="DEPARTMENT")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Department extends BaseEntity {

    @Column(name="NAME")
    private String name;

    @OneToMany (mappedBy = "department")
    private List<Patient> patient;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
