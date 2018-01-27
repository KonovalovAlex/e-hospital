package kz.astonline.ehospital.repository;

import kz.astonline.ehospital.model.base.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;


public interface GenericFormRepository<T extends BaseEntity, I extends Serializable> extends JpaRepository<T, I>{

//    @Query("select f from "+T.+" f where f.medicalCard = :medicalCard")
//    T findByMedicalCard(@Param("medicalCard")MedicalCard medicalCard);
}
