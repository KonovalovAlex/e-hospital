package kz.astonline.ehospital.service.base;




import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

public abstract class AbstractService<T> implements BaseFormService<T> {

    @PersistenceContext
    EntityManager entityManager;


}
