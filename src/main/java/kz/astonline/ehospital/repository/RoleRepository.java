package kz.astonline.ehospital.repository;

import kz.astonline.ehospital.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;

import javax.persistence.QueryHint;

public interface RoleRepository extends JpaRepository<Role,Long> {

    @QueryHints({@QueryHint(name="org.hibernate.cacheable", value="true")})
    @Query("select r from Role r where r.role=:role")
    Role findByRoleName(@Param("role")String role);
}
