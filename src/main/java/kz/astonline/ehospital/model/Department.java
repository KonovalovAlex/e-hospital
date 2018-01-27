package kz.astonline.ehospital.model;



import kz.astonline.ehospital.model.base.BaseEntity;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity @DynamicUpdate @DynamicInsert
@Table(name="DEPARTMENT")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Department extends BaseEntity {

    @Column(name="NAME")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
