package kz.online.ehospital.service.impl;

import kz.online.ehospital.model.Role;
import kz.online.ehospital.repository.RoleRepository;
import kz.online.ehospital.service.RoleService;
import kz.online.ehospital.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role findByRoleName(String role) {
        return roleRepository.findByRoleName(role);
    }

    @Override
    public Role saveOrUpdate(Role entity) {
        return roleRepository.save(entity);
    }

    @Override
    public Role findById(Long id) {
        return roleRepository.findOne(id);
    }


    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }
}
