package com.tudor.appbackend.mappers;

import com.tudor.appbackend.dto.PartnerDto;
import com.tudor.appbackend.dto.ProjectDto;
import com.tudor.appbackend.models.Partner;
import com.tudor.appbackend.models.Project;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DtoMapper {
    PartnerDto toDtoPartner(Partner partner);
    Partner fromDtoPartner(PartnerDto partnerDto);

    List<PartnerDto> toDtoPartnerList(List<Partner> partners);
    List<Partner> fromDtoPartnerList(List<PartnerDto>partnerDtos);
    ProjectDto toDtoProject(Project project);
    Project fromDtoProject(ProjectDto projectDto);

    List<ProjectDto> toDtoProjectList(List<Project> projects);
    List<Project> fromDtoProjectList(List<ProjectDto> projectDtos);
}
