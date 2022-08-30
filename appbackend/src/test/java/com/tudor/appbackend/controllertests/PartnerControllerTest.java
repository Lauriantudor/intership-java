package com.tudor.appbackend.controllertests;

import com.tudor.appbackend.models.Partner;
import com.tudor.appbackend.repo.PartnerRepo;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PartnerControllerTest {


    @Autowired
    private PartnerService service;

    @MockBean
    private PartnerRepo repo;

    @Test
    public void getPartnersTest(){
        when(repo.findAll()).thenReturn(Stream
                .of(new Partner(4, "INSTA", "example@test.com", "(0723)-123-213", "facem teste",0),
                        new Partner(5, "Tud", "exampl@test.com", "(0723)-144-213", "fac teste",0)).collect(Collectors.toList()));
        assertEquals(2,service.getPartners().size());
    }
    @Test
    public void addPartnerTest(){
        Partner part = new Partner();
        part.setId(34);
        part.setName("Boock");
        part.setEmail("boock@gmail.com");
        part.setContactus("(0754)-878-090");
        part.setAboutus("boocks for all");
        part.setProj_id(0);

        service.addPartner(part);
        assertNotNull(repo.findById(part.getId()));
          }
    @Test
    public void getPartnerByIdTest(){
        Partner part = new Partner();
        part.setId(34);
        part.setName("Boock");
        part.setEmail("boock@gmail.com");
        part.setContactus("(0754)-878-090");
        part.setAboutus("boocks for all");
        service.addPartner(part);
        service.findById(34);
        assertEquals(34,part.getId());
    }
    @Test
    public void updatePartnerTest(){
        Partner part = new Partner();
        part.setId(34);
        part.setName("Boock");
        part.setEmail("boock@gmail.com");
        part.setContactus("(0754)-878-090");
        part.setAboutus("boocks for all");
        service.addPartner(part);
        Partner partup = new Partner();
        partup.setId(34);
        partup.setName("Boock");
        partup.setEmail("boock@gmail.com");
        partup.setContactus("(0754)-878-090");
        partup.setAboutus("boocks for you");
        service.updatePartner(34, partup);
       Assertions.assertEquals("boocks for you", partup.getAboutus());
    }

    @Test
    public void deletePartner(){
        Partner part = new Partner();
        part.setId(34);
        part.setName("Boock");
        part.setEmail("boock@gmail.com");
        part.setContactus("(0754)-878-090");
        part.setAboutus("boocks for all");
        service.deleteBiId(part.getId());
        assertNull(part);
    }

}
