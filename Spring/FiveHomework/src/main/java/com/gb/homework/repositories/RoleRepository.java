package com.gb.homework.repositories;

import com.gb.homework.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository  extends JpaRepository<Role, Long> {
   Role findRoleByName(String name);
   Role findRolesById(Long roleId);
   boolean existsRoleByName(String name);
}
