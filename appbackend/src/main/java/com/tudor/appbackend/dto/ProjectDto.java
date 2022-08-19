package com.tudor.appbackend.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
public class ProjectDto {
    private int id;
    private String name;
    private String datestart;
    private String datefinish;
    private String price;
}
