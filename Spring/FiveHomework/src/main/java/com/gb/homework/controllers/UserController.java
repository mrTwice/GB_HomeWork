package com.gb.homework.controllers;

import com.gb.homework.domain.Project;
import com.gb.homework.domain.Role;
import com.gb.homework.domain.User;
import com.gb.homework.services.ProjectService;
import com.gb.homework.services.RoleService;
import com.gb.homework.services.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Controller
@AllArgsConstructor
@CommonsLog(topic = "UserController")
@SessionAttributes("user")
public class UserController {
    private UserService userService;
    private RoleService roleService;
    private ProjectService projectService;

    @GetMapping("/")
    public String getUsers(Model model){
        model.addAttribute("users", userService.allUsers());
        return "users";
    }

    @PostMapping("/")
    public String createUser(User user, Model model){
        log.info(user.getId());
        log.info(user.getUsername());
        log.info(user.getPassword());
        log.info(user.getEmail());
        roleService.allRoles();
        if(userService.createUser(user))
            log.info("New user created: " + user.getUsername());
        else log.info("Username is exist");
        model.addAttribute("users", userService.allUsers());
        return "users";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteUserByID(@PathVariable("id")long id){
        userService.deleteUser(id);
        return "redirect:/";
    }

    @GetMapping("/edit-user/{id}")
    public String updateUser(@PathVariable long id, Model model){
        User user = userService.findUserById(id);
        model.addAttribute("user", user);
        List<Role> allRoles = roleService.allRoles();
        model.addAttribute("allRoles", allRoles);
        List<Project> projects = projectService.allProjects();
        model.addAttribute("allProjects", projects);
        return "/edit-user";
    }
    @PostMapping("/edit-user")
    public String updateUser(User user) {
        userService.updateUser(user);
        return "redirect:/";
    }
}
