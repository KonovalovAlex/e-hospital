package kz.astonline.ehospital.model;

import kz.astonline.ehospital.model.base.BaseEntity;

import javax.persistence.Entity;

/**
 * Created by Alex on 12.01.2018.
 */
@Entity
public class TypeForm extends BaseEntity {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
