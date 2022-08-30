package com.tudor.appbackend.servicies;

import com.tudor.appbackend.dto.ProjectDto;
import com.tudor.appbackend.exceptions.ResourceNotFoundException;
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
    public  ProjectDto updateProject(int id , ProjectDto projectDto){
//                Optional<Project> findProject = projectRepo.findById(projectDto.getId());
//                if (findProject.isPresent()){
//                    Project project = new Project();
//                    BeanUtils.copyProperties(projectDto, project);
//                    project =projectRepo.save(project);
//                    BeanUtils.copyProperties(project,projectDto);
//                }
//                else {
//                    //TODO
//                }
//                return projectDto;
        Project projectData = projectRepo.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Project with id"+ id+ "not exist"));
        if (projectData !=null) {

            projectData.setName(projectDto.getName());
            projectData.setDatestart(projectDto.getDatestart());
            projectData.setDatefinish(projectDto.getDatefinish());
            projectData.setDatestart(projectDto.getDatefinish());
            projectRepo.save(projectData);
            return projectMapper.toDto(projectData);
        }

        return null;

        //return projectMapper.fromDto(addProject(projectMapper.toDto(project)));
    }
    public void delete(int id) {
        projectRepo.deleteById(id);
    }
}
