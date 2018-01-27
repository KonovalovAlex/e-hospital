package kz.astonline.ehospital.service;

import kz.astonline.ehospital.model.Role;
import kz.astonline.ehospital.service.base.BaseService;

public interface RoleService extends BaseService<Role,Long> {

    Role findByRoleName(String role);
}
