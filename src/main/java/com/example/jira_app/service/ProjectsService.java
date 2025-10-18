package com.example.jira_app.service;

import com.example.jira_app.model.ProjectsEntity;
import com.example.jira_app.model.UsersEntity;
import com.example.jira_app.respository.ProjectsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectsService {
    @Autowired
    ProjectsRepository projectRepo;

    public List<ProjectsEntity> getAllProject(){
        return projectRepo.findAll();
    }

    public ProjectsEntity addNewProject(ProjectsEntity proj){
       return projectRepo.save(proj);
    }

    public Long deleteAllProject(){
        Long count = projectRepo.count();
        projectRepo.deleteAll();
        return count;
    }

    public String getByProjectId(Long id){
       boolean isPresent =  projectRepo.findById(id).isPresent();
        projectRepo.deleteById(id);
       return isPresent ? "Deleted" : "item Not Found";
    }

    public List<ProjectsEntity> getbyOwnerId(Long id){
        UsersEntity toTest =new UsersEntity();
        toTest.setId(id);
        List<ProjectsEntity> allPorjectWithOwner = projectRepo.findByOwner(id);
        return allPorjectWithOwner;
    }

}
