package com.example.jira_app.dto;

import java.util.List;


public class ErrorDTO {
    public int errorCode;
    public List<String> message;

    public ErrorDTO(int errorCode, List<String> message) {
        this.errorCode = errorCode;
        this.message = message;
    }
}
