package com.example.jira_app.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
public class CustomException extends Throwable {
    private int errorCode;
    private String errorMessage;
    private HttpStatus statusCode;
}
