package com.gb.homework.services;

import com.gb.homework.domain.Project;
import com.gb.homework.repositories.ProjectRepository;
import com.gb.homework.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private UserRepository userRepository;

    public List<Project> allProjects(){
        return projectRepository.findAll();
    }

    public Project saveProject(Project project){
        Project projectFromDb = projectRepository.findProjectByName(project.getName());

        if(projectFromDb != null)
            return  projectFromDb;

        project.setCreatedDate(LocalDateTime.now());
        projectRepository.save(project);
        return project;
    }

    public boolean deleteProjectById(Long projectId){
        if(projectRepository.findById(projectId).isPresent()){
            projectRepository.deleteById(projectId);
            return true;
        }
        return false;
    }

}
