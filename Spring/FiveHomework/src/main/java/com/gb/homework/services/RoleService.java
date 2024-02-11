package com.gb.homework.services;

import com.gb.homework.domain.Role;
import com.gb.homework.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public boolean createNewRole(String role){
        if(roleRepository.findAll().isEmpty()){
            roleRepository.save(new Role("ROLE_USER"));
            roleRepository.save(new Role("ROLE_ADMIN"));
        }

        Role roleFromDB = roleRepository.findRoleByName(role);
        if (roleFromDB != null)
            return false;
        roleRepository.save(new Role(role));
        return true;
    }

    public boolean deleteRoleById(Long roleId){
        if(roleRepository.findById(roleId).isPresent()){
            roleRepository.deleteById(roleId);
            return true;
        }
        return false;
    }

    public List<Role> allRoles(){
        return roleRepository.findAll();
    }

    public Role findRoleById(Long roleId){
        Role roleFormBd = roleRepository.findRolesById(roleId);
        return roleFormBd;
    }

    public boolean updateRole(Role role){
        if(roleRepository.findRoleByName(role.getName()) != null)
            return false;
        roleRepository.save(role);
        return true;
    }

}
