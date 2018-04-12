package kz.online.ehospital.service;

import kz.online.ehospital.model.Role;
import kz.online.ehospital.service.base.BaseService;
import kz.online.ehospital.service.base.BaseService;

public interface RoleService extends BaseService<Role,Long> {

    Role findByRoleName(String role);
}
