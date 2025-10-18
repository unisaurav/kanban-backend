package com.example.jira_app.config;

import com.example.jira_app.dto.ErrorDTO;
import org.hibernate.PropertyValueException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorDTO> handelUserNotFound(CustomException e) {
        return new ResponseEntity<>(new ErrorDTO(e.getErrorCode(), e.getErrorMessage()), e.getStatusCode());
    }

    @ExceptionHandler(PropertyValueException.class)
    public ResponseEntity<ErrorDTO> fdsa(PropertyValueException e) {
        System.out.println(e.getPropertyName());
        return new ResponseEntity<>(new ErrorDTO(404, "Field '"+e.getPropertyName()+"' not Found in request body"), HttpStatus.PARTIAL_CONTENT);
    }
}
