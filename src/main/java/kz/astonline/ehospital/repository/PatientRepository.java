package kz.astonline.ehospital.repository;

import kz.astonline.ehospital.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;

import javax.persistence.QueryHint;
import java.util.List;

public interface PatientRepository extends JpaRepository <Patient , Long> {

    @QueryHints({@QueryHint(name="org.hibernate.cacheable", value="true")})
    @Query("SELECT p from Patient p where " +
            "p.name=:name and p.surName=:surName")
    List<Patient> findByFullName(@Param("name")String name, @Param("surName")String surName);

    @QueryHints({@QueryHint(name="org.hibernate.cacheable", value="true")})
    @Query("SELECT p from Patient p inner join  p.card c where p.name=:name and p.surName=:surName and c.isActive=:isActive")
    List<Patient> findByFullNameAndOpeningCard(@Param("name")String name, @Param("surName")String surName, @Param("isActive") Boolean isActive);

}
