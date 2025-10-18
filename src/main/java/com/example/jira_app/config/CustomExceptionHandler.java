package com.example.jira_app.config;

import com.example.jira_app.dto.ErrorDTO;
import org.hibernate.PropertyValueException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorDTO> handelUserNotFound(CustomException e) {
        List<String> list = new ArrayList<>(Arrays.asList(e.getErrorMessage()));

        return new ResponseEntity<>(new ErrorDTO(e.getErrorCode(), list), e.getStatusCode());
    }

    @ExceptionHandler(PropertyValueException.class)
    public ResponseEntity<ErrorDTO> propertyNotFoundInRequest(PropertyValueException e) {
        System.out.println(e.getPropertyName());
        return new ResponseEntity<>(new ErrorDTO(404, new ArrayList<>(Arrays.asList(e.getPropertyName()))), HttpStatus.PARTIAL_CONTENT);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDTO> handelContraint(MethodArgumentNotValidException e) {
        List<String> message = e.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).toList();
        return new ResponseEntity<>(new ErrorDTO(404, message), HttpStatus.PARTIAL_CONTENT);
    }

}

