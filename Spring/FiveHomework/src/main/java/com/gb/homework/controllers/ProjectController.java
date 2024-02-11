package com.gb.homework.controllers;

import com.gb.homework.domain.Project;
import com.gb.homework.services.ProjectService;
import com.gb.homework.services.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@CommonsLog(topic = "ProjectController")
public class ProjectController {

    private ProjectService projectService;
    private UserService userService;

    @GetMapping("/projects")
    public String getProjects(Model model){
        model.addAttribute("projects", projectService.allProjects());
        return "projects";
    }

    @RequestMapping(value = "/projects/delete/{id}", method = RequestMethod.GET)
    public String deleteProjectByID(@PathVariable("id")long id){
        projectService.deleteProjectById(id);
        return "redirect:/projects";
    }

    @PostMapping("/projects")
    public String createProject(Model model, Project newProject){
        projectService.saveProject(newProject);
        model.addAttribute("projects", projectService.allProjects());
        return "projects";
    }

}
