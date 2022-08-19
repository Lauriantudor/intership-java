package com.tudor.appbackend.mappers;

import com.tudor.appbackend.dto.ProjectDto;
import com.tudor.appbackend.models.Project;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectMapper {
    ProjectDto toDto(Project project);
    Project fromDto(ProjectDto projectDto);

    List<ProjectDto> toDtoList(List<Project> projects);
    List<Project> fromDtoList(List<ProjectDto> projectDtos);
}
