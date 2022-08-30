package com.tudor.appbackend.controllers;


import com.tudor.appbackend.dto.PartnerDto;
import com.tudor.appbackend.models.Partner;
import com.tudor.appbackend.servicies.PartnerService;
import com.tudor.appbackend.servicies.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/partner")
@CrossOrigin
public class PartnerController {

    @Autowired
    private PartnerService partnerService;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;
    @PostMapping

    public ResponseEntity<PartnerDto> addPartner(@RequestBody PartnerDto partDto){
        partDto.setId(sequenceGeneratorService.getSequenceNumber(Partner.SEQUENCE_NAME));
        return  new ResponseEntity<PartnerDto>(partnerService.addPartner(partDto), HttpStatus.OK);
    }
    @GetMapping

    public List<PartnerDto> getPartners(){
        return partnerService.getPartners();
    }
    @GetMapping("/{id}")

    public PartnerDto getProjectById(@PathVariable("id") int id){

        return partnerService.findById(id);
    }
    @PutMapping("{id}")
    public PartnerDto updatePartner(@PathVariable("id") int id,@RequestBody Partner partner){
        return partnerService.updatePartner(id, partner);
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable("id") int id){
         partnerService.deleteBiId(id);
         return "deleted";
    }
    @GetMapping("getpartnersOf/{id}")

    public List<Partner> partnerOfZ(@PathVariable("id") int id){
         return partnerService.getPartnerOf(id);
    }
}
