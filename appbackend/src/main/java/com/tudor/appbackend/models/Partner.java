package com.tudor.appbackend.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("partner")
public class Partner {

    @Transient
    public static final String SEQUENCE_NAME="partner_sequence";
    private int id;
    private String name;
    private String email;
    private String contactus;
    private String aboutus;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactus() {
        return contactus;
    }

    public void setContactus(String contactus) {
        this.contactus = contactus;
    }

    public String getAboutus() {
        return aboutus;
    }

    public void setAboutus(String aboutus) {
        this.aboutus = aboutus;
    }


}
