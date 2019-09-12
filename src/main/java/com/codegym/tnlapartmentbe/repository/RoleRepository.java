package com.codegym.tnlapartmentbe.repository;

import com.codegym.tnlapartmentbe.entity.Role;
import com.codegym.tnlapartmentbe.entity.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(RoleName roleName);
}
