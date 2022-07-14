package com.tudy.appbackend.repo;

import com.tudy.appbackend.model.Project;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProjectRepo extends MongoRepository<Project,Integer> {
}
