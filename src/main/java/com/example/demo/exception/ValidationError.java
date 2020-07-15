package com.example.demo.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.List;

public class ValidationError {
//    @JsonInclude(JsonInclude.Include.NON_EMPTY)
//    private List<ObjectError> errors = new ArrayList<>();
//    private String description;
//
//
//    public ValidationError(String description) {
//        this.description = description;
//    }
//
//    public void addValidationError(ObjectError objectError) {
//        errors.add(objectError);
//    }
//
//
//
//    public List<ObjectError> getErrors() {
//        return errors;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    @Override
//    public String toString() {
//        return "ValidationError{" +
//                "errors=" + errors +
//                ", description='" + description + '\'' +
//                '}';
//    }
}