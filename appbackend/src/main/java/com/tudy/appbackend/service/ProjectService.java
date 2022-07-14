package com.tudy.appbackend.service;

import com.tudy.appbackend.model.Project;
import com.tudy.appbackend.repo.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepo projectRepo;

    public Project saveOrUpdate(Project prj){
        return projectRepo.save(prj);
    }
}
