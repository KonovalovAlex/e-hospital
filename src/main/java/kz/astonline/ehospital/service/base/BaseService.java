package kz.astonline.ehospital.service.base;

import org.springframework.cache.annotation.CacheEvict;

import java.util.List;

public interface BaseService <T, I> {

    @CacheEvict(value = "serviceCache", allEntries = true)
    T saveOrUpdate(T entity);

//    @Cacheable(value = "serviceCache")
    T findById (I id);

//    @CacheEvict(value = "serviceCache")
    void delete(I id);

    //@Cacheable(value = "serviceCache")
    List<T> findAll();
}
