package com.tudor.appbackend.servicies;


import com.tudor.appbackend.models.Partner;
import com.tudor.appbackend.repo.PartnerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PartnerService {
    @Autowired
    private PartnerRepo partnerRepo;

    public Partner addPartner(Partner prt){
        return partnerRepo.save(prt);
    }
    public List<Partner> getPartners() {
        return partnerRepo.findAll();
    }

    public Optional<Partner> findById(int id) {
        return partnerRepo.findById(id);
    }
    public Partner updatePartner(int id, Partner partner){
        Optional<Partner> findById = partnerRepo.findById(id);
        if (findById.isPresent()){
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
        return null;
    }
    public void deleteBiId(int id){
        partnerRepo.deleteById(id);
    }
}
