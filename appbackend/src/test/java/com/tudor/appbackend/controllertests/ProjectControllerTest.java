package com.tudor.appbackend.controllertests;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import com.tudor.appbackend.models.Project;
import com.tudor.appbackend.repo.ProjectRepo;
import com.tudor.appbackend.servicies.PartnerService;
import com.tudor.appbackend.servicies.ProjectService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectControllerTest {


    @Autowired
    private ProjectService service;

    @Autowired
    private PartnerService partnerService;

    @MockBean
    private ProjectRepo repo;

    @Test
    public void getProjectsTest(){
        when(repo.findAll()).thenReturn(Stream
                .of(new Project(4, "INSTA", "09.08.2005","24.07.2006","5432$"),
                        new Project(5, "IN", "09.08.2005","24.07.2006","5432$")).collect(Collectors.toList()));
        assertEquals(2,service.getProjects().size());
    }
//    @Test
//    public void addProjectTest(){
//        Project prj = new Project();
//        prj.setId(34);
//        prj.setName("Boock");
//        prj.setDatestart("09.08.2346");
//        prj.setDatefinish("09.08.2347");
//        prj.setPrice("100$");
//        service.addProject(prj);
//        assertNotNull(repo.findById(prj.getId()));
//          }
//    @Test
//     public void addProjectToTest(){
//         Project prj = new Project();
//         prj.setId(34);
//         prj.setName("Boock");
//         prj.setDatestart("09.08.2346");
//         prj.setDatefinish("09.08.2347");
//         prj.setPrice("100$");
//         service.addProject(prj);
//
//         Partner part = new Partner();
//         part.setId(21);
//         part.setName("Boock");
//         part.setEmail("boock@gmail.com");
//         part.setContactus("(0754)-878-090");
//         part.setAboutus("boocks for all");
//         part.setProj_id(0);
//         partnerService.addPartner(part);
//         partnerService.addproject(34,21);
//         Assertions.assertEquals(34, part.getProj_id());
//     }
//    @Test
//    public void getProjectByIdTest(){
//        Project prj = new Project();
//        prj.setId(34);
//        prj.setName("Boock");
//        prj.setDatestart("09.08.2346");
//        prj.setDatefinish("09.08.2347");
//        prj.setPrice("100$");
//        service.addProject(prj);
//        service.findById(34);
//        assertEquals(34,prj.getId());
//    }
//    @Test
//    public void updateProjectTest(){
//        Project prj = new Project();
//        prj.setId(34);
//        prj.setName("Boock");
//        prj.setDatestart("09.08.2346");
//        prj.setDatefinish("09.08.2347");
//        prj.setPrice("100$");
//        service.addProject(prj);
//        Project prjUP = new Project();
//        prjUP.setId(34);
//        prjUP.setName("BoockS");
//        prjUP.setDatestart("09.08.2346");
//        prjUP.setDatefinish("09.08.2347");
//        prjUP.setPrice("50$");
//        service.updateProject(34, prjUP);
//       Assertions.assertEquals("50$", prjUP.getPrice());
//    }

    @Test
    public void deleteProject(){
        Project prj = new Project(
                34,
               "Boock",
                "09.08.2346",
                "09.08.2347",
                "100$"
        );
        service.delete(prj.getId());
        assertNull(prj);
    }

}
