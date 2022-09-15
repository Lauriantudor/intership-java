package com.tudor.appbackend.servicies;

import com.tudor.appbackend.dto.ProjectDto;
import com.tudor.appbackend.exceptions.ResourceNotFoundException;
import com.tudor.appbackend.mappers.DtoMapper;
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
    private DtoMapper mapper;

    public ProjectDto addProject(ProjectDto projectDto){
        Project project =  projectRepo.save(mapper.fromDtoProject(projectDto));
        return mapper.toDtoProject(project);
    }

    public List<ProjectDto> getProjects() {
        List<Project> projects =projectRepo.findAll();
        return mapper.toDtoProjectList(projects);
    }



    public Optional<Project> findById(int id)
    {
        return  projectRepo.findById(id);
    }
    public  ProjectDto updateProject(int id , ProjectDto projectDto){
        Project projectData = projectRepo.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Project with id"+ id+ "not exist"));
        if (projectData !=null) {

            projectData.setName(projectDto.getName());
            projectData.setDatestart(projectDto.getDatestart());
            projectData.setDatefinish(projectDto.getDatefinish());
            projectData.setDatestart(projectDto.getDatefinish());
            projectRepo.save(projectData);
            return mapper.toDtoProject(projectData);
        }

        return null;

        //return projectMapper.fromDto(addProject(projectMapper.toDto(project)));
    }
    public void delete(int id) {
        projectRepo.deleteById(id);
    }
}
