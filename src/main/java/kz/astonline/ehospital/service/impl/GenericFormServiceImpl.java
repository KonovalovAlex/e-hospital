package kz.astonline.ehospital.service.impl;

import kz.astonline.ehospital.model.base.BaseEntity;
import kz.astonline.ehospital.repository.GenericFormRepository;
import kz.astonline.ehospital.service.GenericFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Service
@Transactional
public class GenericFormServiceImpl<T extends BaseEntity, I extends Serializable> implements GenericFormService<T, I> {

    @Autowired
    private GenericFormRepository<T, I> genericFormRepository;


    @Override
    public T saveOrUpdate(T entity) {
        return genericFormRepository.save(entity);
    }

    @Override
    public T findById(I id) {
        return genericFormRepository.findOne(id);
    }

    @Override
    public void delete(I id) {

    }

    @Override
    public List<T> findAll() {
        return genericFormRepository.findAll();
    }
}
