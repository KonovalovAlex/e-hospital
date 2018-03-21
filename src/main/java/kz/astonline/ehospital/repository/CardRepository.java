package kz.astonline.ehospital.repository;

import kz.astonline.ehospital.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;

import javax.persistence.QueryHint;
import java.util.List;

/**
 * Created by Alex on 10.01.2018.
 */
public interface CardRepository extends JpaRepository <Card,Long> {
    @QueryHints({@QueryHint(name = "org.hibernate.cacheable", value = "true")})
    @Query("SELECT c from Card c where c.patient.id=:id and c.isActive=:isActive")
    List<Card> findCardByIdPatient(@Param("id") long id, @Param("isActive") Boolean isActive);
}
