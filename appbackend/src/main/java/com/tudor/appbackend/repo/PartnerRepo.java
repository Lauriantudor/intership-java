package com.tudor.appbackend.repo;

import com.tudor.appbackend.models.Partner;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PartnerRepo extends MongoRepository<Partner, Integer> {
}
