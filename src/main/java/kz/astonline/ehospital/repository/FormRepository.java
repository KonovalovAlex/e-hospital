package kz.astonline.ehospital.repository;

import kz.astonline.ehospital.model.Form;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Alex on 12.01.2018.
 */
public interface FormRepository extends JpaRepository <Form,Long> {
}
