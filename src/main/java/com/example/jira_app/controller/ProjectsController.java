package com.example.jira_app.controller;

import com.example.jira_app.dto.AddProjectRequestDTO;
import com.example.jira_app.model.ProjectsEntity;
import com.example.jira_app.service.ProjectsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProjectsController {
    @Autowired
    ProjectsService projectService;

    @GetMapping("/getAllProject")
    public List<ProjectsEntity> allProjects(){
        return projectService.getAllProject();
    }

    @PostMapping("/addProject")
    public ProjectsEntity addProject(@Valid @RequestBody AddProjectRequestDTO proj) {
      return   projectService.addNewProject(new ProjectsEntity(proj.getName(),proj.getDescription(),proj.getOwner()));
    }

    @DeleteMapping("/deleteAllProjects")
    public String deleteAllProject(){
        return "Deleted "+ projectService.deleteAllProject() + "records";
    }

    @GetMapping("/getProjectByProjectId/{id}")
    public String byProjectid(@PathVariable Long id){
      return   projectService.getByProjectId(id);
    }


    @GetMapping("/getProjectByOwnerId/{id}")
    public List<ProjectsEntity> byOwnerId(@PathVariable Long id){
        return   projectService.getbyOwnerId(id);
    }

}
