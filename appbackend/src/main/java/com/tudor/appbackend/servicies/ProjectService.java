package com.tudor.appbackend.servicies;

import com.tudor.appbackend.models.Project;
import com.tudor.appbackend.repo.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepo projectRepo;

    public Project addProject(Project prj){
        return projectRepo.save(prj);
    }

    public List<Project> getProjects() {
        return projectRepo.findAll();
    }

    public Optional<Project> findById(int id)
    {
        return  projectRepo.findById(id);
    }
    public  Project updateProject(int id, Project project){
        Optional<Project> findById = projectRepo.findById(id);
        if (findById.isPresent()){
            Project project1 = findById.get();
            if (project.getName() != null && !project.getName().isEmpty())
                project1.setName(project.getName());
            if (project.getDatestart() != null && !project.getDatestart().isEmpty())
                project1.setDatestart(project.getDatestart());
            if (project.getDatefinish() != null && !project.getDatefinish().isEmpty())
                project1.setDatestart(project.getDatefinish());

            return projectRepo.save(project1);
        }
        return null;
    }
    public void delete(int id) {
         projectRepo.deleteById(id);
    }
}
