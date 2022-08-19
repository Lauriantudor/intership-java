package com.tudor.appbackend.servicies;


import com.tudor.appbackend.models.Partner;
import com.tudor.appbackend.repo.PartnerRepo;
import com.tudor.appbackend.repo.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import  com.mongodb.client.MongoCollection ;

import java.util.List;
import java.util.Optional;
@Service
public class PartnerService {
    @Autowired
    private PartnerRepo partnerRepo;
    @Autowired
    private ProjectRepo projectRepo;
    private MongoCollection mongoCollection;
    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;
    private final MongoTemplate mongoTemplate;

    public PartnerService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }


    public List<Partner> getPartners() {
        return partnerRepo.findAll();
    }

    public Optional<Partner> findById(int id) {
        return partnerRepo.findById(id);
    }
    public Partner updatePartnerOrCreate( Partner partner){
        Optional<Partner> findById = partnerRepo.findById(partner.getId());
        if (findById == null){
            partner.setId(sequenceGeneratorService.getSequenceNumber(Partner.SEQUENCE_NAME));
            return partnerRepo.save(partner);

        }else {
            Partner partner1 = findById.get();
            if (partner.getName() != null && !partner.getName().isEmpty())
                partner1.setName(partner1.getName());
            if (partner.getEmail() != null && !partner.getEmail().isEmpty())
                partner1.setEmail(partner.getEmail());
            if ( partner.getContactus() != null && !partner.getContactus().isEmpty())
                partner1.setContactus(partner.getContactus());
            if ( partner.getAboutus() != null && !partner.getAboutus().isEmpty())
                partner1.setAboutus(partner.getAboutus());

            return partnerRepo.save(partner1);


        }

    }
    public Partner addproject(int proj_id,int part_id){
        Optional<Partner> findById = partnerRepo.findById(part_id);

        if (findById.isPresent()){
            Partner partner1 = findById.get();
            partner1.setProj_id(proj_id);
            return partnerRepo.save(partner1);

        }
        return null;
    }

    public List<Partner> getPartnerOf(int prj){
        Query query =new Query()
                .addCriteria(Criteria.where("proj_id").is(prj));
       return mongoTemplate.find(query, Partner.class);
    }
    public void deleteBiId(int id){
        partnerRepo.deleteById(id);
    }
}
