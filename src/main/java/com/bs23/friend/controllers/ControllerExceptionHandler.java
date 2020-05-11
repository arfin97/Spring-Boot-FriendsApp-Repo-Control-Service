package com.bs23.friend.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.xml.bind.ValidationException;
import java.util.List;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ValidationException.class)
    ErrorMessage errorHandler(ValidationException e){
        return new ErrorMessage("404", e.getMessage());
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    List<FieldError> exceptionHandler111(MethodArgumentNotValidException e){
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        return fieldErrors;
    }

//    @ExceptionHandler(ValidationException.class)
//    ResponseEntity<String> exceptionHandler(ValidationException e){
//        return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
//    }

}
