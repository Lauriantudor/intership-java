package com.tudor.appbackend.repo;

import com.tudor.appbackend.models.Project;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProjectRepo extends MongoRepository<Project,Integer> {
}
