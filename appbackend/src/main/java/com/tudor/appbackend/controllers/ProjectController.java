package com.tudor.appbackend.controllers;

import com.tudor.appbackend.dto.ProjectDto;
import com.tudor.appbackend.models.Partner;
import com.tudor.appbackend.models.Project;
import com.tudor.appbackend.servicies.PartnerService;
import com.tudor.appbackend.servicies.ProjectService;
import com.tudor.appbackend.servicies.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest/project")
@CrossOrigin
public class ProjectController {

    @Autowired
    private ProjectService projectService;
    @Autowired
    private PartnerService partnerService;
    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;
    @PostMapping

    public ResponseEntity<ProjectDto> addProject(@RequestBody ProjectDto prjDto){
        prjDto.setId(sequenceGeneratorService.getSequenceNumber(Project.SEQUENCE_NAME));
        return  new ResponseEntity<ProjectDto>(projectService.addProject(prjDto), HttpStatus.OK);
    }
    @GetMapping
    public List<ProjectDto> getProjects(){

        return projectService.getProjects();
    }
    @GetMapping("{id}")
    public Optional<Project> getProjectById(@PathVariable("id") int id){

        return projectService.findById(id);
    }
    @PutMapping("{id}")
    public ProjectDto updateProject(@PathVariable("id") int id, @RequestBody ProjectDto projectDto){
        return projectService.updateProject(id, projectDto);
    }
    @PostMapping("addto/{id}")

    public void addpartner(@PathVariable("id") int id,
                           @RequestBody Partner partner) {
        partnerService.addproject(id, partner.getId());

    }




    @DeleteMapping("{id}")
    @CrossOrigin(origins = "http://localhost:4200/")
    public String delete(@PathVariable("id") int id){
         projectService.delete(id);
         return "deleted";
    }
}
