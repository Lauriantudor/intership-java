
package com.tudor.appbackend.servicies;



import com.tudor.appbackend.dto.PartnerDto;
import com.tudor.appbackend.exceptions.ResourceNotFoundException;
import com.tudor.appbackend.mappers.DtoMapper;
import com.tudor.appbackend.models.Partner;
import com.tudor.appbackend.repo.PartnerRepo;
import com.tudor.appbackend.repo.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
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

    @Autowired
    private DtoMapper mapper;
    private final MongoTemplate mongoTemplate;

    public PartnerService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public PartnerDto addPartner(PartnerDto partnerDto){
        Partner partner = partnerRepo.save(mapper.fromDtoPartner(partnerDto));
        return mapper.toDtoPartner(partner);
    }
    public List<PartnerDto> getPartners() {
        List<Partner> partners = partnerRepo.findAll();
        return mapper.toDtoPartnerList(partners);
    }

    public PartnerDto findById(int id) {
        Partner partner =partnerRepo.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Partner with id "+id+ "not exist"));
        return mapper.toDtoPartner(partner);
    }
    public PartnerDto updatePartner( int id, Partner partner){
        Partner partnerData = partnerRepo.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Partner with id"+ id+ "not exist"));
            if (partnerData!=null){
                partnerData.setName(partner.getName());
                partnerData.setEmail(partner.getEmail());
                partnerData.setContactus(partner.getContactus());
                partnerData.setAboutus(partner.getAboutus());
                partnerRepo.save(partnerData);
                return mapper.toDtoPartner(partnerData);
            }
                return null;
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
