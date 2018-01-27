package kz.astonline.ehospital.repository;

import kz.astonline.ehospital.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;

import javax.persistence.QueryHint;

/**
 * Created by Alex on 10.01.2018.
 */
public interface CardRepository extends JpaRepository <Card,Long> {
}
