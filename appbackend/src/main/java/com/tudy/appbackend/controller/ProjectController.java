package com.tudy.appbackend.controller;

import com.tudy.appbackend.model.Project;
import com.tudy.appbackend.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping
    public ResponseEntity<Project> saveOrUpdate(@RequestBody Project prj){
        return  new ResponseEntity<Project>(projectService.saveOrUpdate(prj), HttpStatus.OK);
    }
}
