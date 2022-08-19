package com.tudor.appbackend.repo;

import com.tudor.appbackend.models.Partner;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PartnerRepo extends MongoRepository<Partner, Integer> {

}
