package com.gb.homework.controllers;

import com.gb.homework.domain.Project;
import com.gb.homework.domain.Role;
import com.gb.homework.domain.User;
import com.gb.homework.services.RoleService;
import lombok.AllArgsConstructor;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@CommonsLog(topic = "RoleController")
public class RoleController {
    private RoleService roleService;

    @GetMapping("/roles")
    public String getRoles(Model model){
        model.addAttribute("roles", roleService.allRoles());
        return "roles";
    }

    @RequestMapping(value = "/roles/delete/{id}", method = RequestMethod.GET)
    public String deleteRoleByID(@PathVariable("id")long id){
        roleService.deleteRoleById(id);
        return "redirect:/roles";
    }

    @PostMapping("/roles")
    public String createRole(Model model, Role newRole){
        if(roleService.createNewRole(newRole.getName()))
            log.info("New role created: " + newRole.getName());
        else
            return "roles";
        model.addAttribute("roles", roleService.allRoles());
        return "roles";
    }

    @GetMapping("/edit-role/{id}")
    public String updateUser(@PathVariable long id, Model model){
        Role role = roleService.findRoleById(id);
        model.addAttribute("role", role);
        return "/edit-role";
    }
    @PostMapping("/edit-role")
    public String updateRole(Role role) {
        roleService.updateRole(role);
        return "redirect:/roles";
    }

}
