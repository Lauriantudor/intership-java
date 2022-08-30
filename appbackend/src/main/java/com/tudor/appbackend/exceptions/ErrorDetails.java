package com.tudor.appbackend.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@AllArgsConstructor
@Setter
public class ErrorDetails {
    private Date  timestamp;
    private String message;
    private String details;
}
