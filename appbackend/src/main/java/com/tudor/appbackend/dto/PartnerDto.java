package com.tudor.appbackend.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document("partner")
public class PartnerDto {
    private int id;
    private String name;
    private String email;
    private String contactus;
    private String aboutus;
    private int prj_id;

}
