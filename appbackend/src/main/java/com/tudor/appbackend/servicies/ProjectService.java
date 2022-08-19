package com.tudor.appbackend.servicies;

import com.tudor.appbackend.dto.ProjectDto;
import com.tudor.appbackend.mappers.ProjectMapper;
import com.tudor.appbackend.models.Partner;
import com.tudor.appbackend.models.Project;
import com.tudor.appbackend.repo.PartnerRepo;
import com.tudor.appbackend.repo.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepo projectRepo;
    @Autowired
    private PartnerRepo partnerRepo;

    @Autowired
    private ProjectMapper projectMapper;

    public ProjectDto addProject(ProjectDto projectDto){
        Project project =  projectRepo.save(projectMapper.fromDto(projectDto));
        return projectMapper.toDto(project);
    }

    public List<ProjectDto> getProjects() {
        List<Project> projects =projectRepo.findAll();
        return projectMapper.toDtoList(projects);
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
                project1.setDatefinish(project.getDatefinish());
            if (project.getPrice() != null && !project.getPrice().isEmpty())
                project1.setDatestart(project.getDatefinish());

            return projectRepo.save(project1);
        }
        return null;
    }
    public void delete(int id) {
        projectRepo.deleteById(id);
    }
}
