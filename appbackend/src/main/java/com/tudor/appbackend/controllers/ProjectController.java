package com.tudor.appbackend.controllers;

import com.tudor.appbackend.models.Project;
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

public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;
    @PostMapping
    @CrossOrigin(origins = "http://localhost:4200/")
    public ResponseEntity<Project> addProject(@RequestBody Project prj){
        prj.setId(sequenceGeneratorService.getSequenceNumber(Project.SEQUENCE_NAME));
        return  new ResponseEntity<Project>(projectService.addProject(prj), HttpStatus.OK);
    }
    @GetMapping
    @CrossOrigin(origins = "http://localhost:4200/")
    public List<Project> getProjects(){
        return projectService.getProjects();
    }
    @GetMapping("{id}")
    public Optional<Project> getProjectById(@PathVariable("id") int id){
        return projectService.findById(id);
    }
    @PutMapping("{id}")
    @CrossOrigin(origins = "http://localhost:4200/")
    public Project updateProject(@PathVariable("id") int id, @RequestBody Project project){
        return projectService.updateProject(id, project);
    }

    @DeleteMapping("{id}")
    @CrossOrigin(origins = "http://localhost:4200/")
    public String delete(@PathVariable("id") int id){
         projectService.delete(id);
         return "deleted";
    }
}
