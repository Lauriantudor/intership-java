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
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;
    @PostMapping("/add")
    public ResponseEntity<Project> addProject(@RequestBody Project prj){
        prj.setId(sequenceGeneratorService.getSequenceNumber(Project.SEQUENCE_NAME));
        return  new ResponseEntity<Project>(projectService.addProject(prj), HttpStatus.OK);
    }
    @GetMapping("/list")
    public List<Project> getProjects(){
        return projectService.getProjects();
    }
    @GetMapping("/list/{id}")
    public Optional<Project> getProjectById(@PathVariable("id") int id){
        return projectService.findById(id);
    }
    @PutMapping("/update/{id}")
    public Project updateProject(@PathVariable("id") int id, @RequestBody Project project){
        return projectService.updateProject(id, project);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id){
         projectService.delete(id);
         return "deleted";
    }
}
