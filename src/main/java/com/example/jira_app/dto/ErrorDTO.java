package com.example.jira_app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;


public class ErrorDTO {
    public int errorcode;
    public String message;

    public ErrorDTO(int errorcode, String message) {
        this.errorcode = errorcode;
        this.message = message;
    }
}
