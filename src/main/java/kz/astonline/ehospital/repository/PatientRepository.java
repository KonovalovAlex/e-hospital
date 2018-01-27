package kz.astonline.ehospital.repository;

import kz.astonline.ehospital.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;

import javax.persistence.QueryHint;

public interface PatientRepository extends JpaRepository <Patient , Long> {

    @QueryHints({@QueryHint(name="org.hibernate.cacheable", value="true")})
    @Query("SELECT p from Patient p where " +
            "p.name=:name and p.surName=:surName")
    Patient findByFullName(@Param("name")String name, @Param("surName")String surName);

}
