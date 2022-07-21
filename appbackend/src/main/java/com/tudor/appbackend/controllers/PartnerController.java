package com.tudor.appbackend.controllers;


import com.tudor.appbackend.models.Partner;
import com.tudor.appbackend.models.Project;
import com.tudor.appbackend.servicies.PartnerService;
import com.tudor.appbackend.servicies.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/partner")

public class PartnerController {

    @Autowired
    private PartnerService partnerService;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;
    @PostMapping
    @CrossOrigin("http://localhost:4200")
    public ResponseEntity<Partner> addPartner(@RequestBody Partner part){
        part.setId(sequenceGeneratorService.getSequenceNumber(Partner.SEQUENCE_NAME));
        return  new ResponseEntity<Partner>(partnerService.addPartner(part), HttpStatus.OK);
    }
    @GetMapping
    @CrossOrigin("http://localhost:4200")
    public List<Partner> getPartners(){
        return partnerService.getPartners();
    }
    @GetMapping("/{id}")
    @CrossOrigin("http://localhost:4200")
    public Optional<Partner> getProjectById(@PathVariable("id") int id){

        return partnerService.findById(id);
    }
    @PutMapping("/{id}")
    @CrossOrigin("http://localhost:4200")
    public Partner updatePartner(@PathVariable("id") int id, @RequestBody Partner partner){
        return partnerService.updatePartner(id, partner);
    }

    @DeleteMapping("{id}")
    @CrossOrigin("http://localhost:4200")
    public String delete(@PathVariable("id") int id){
         partnerService.deleteBiId(id);
         return "deleted";
    }
}
