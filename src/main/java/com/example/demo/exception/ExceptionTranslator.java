package com.example.demo.exception;

import com.example.demo.domain.MyMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.*;

@RestControllerAdvice
public class ExceptionTranslator {
    @Autowired
    @Qualifier("messconfig")
    MessageSource messageSource;

    @Autowired
    MyMessage myMessage;
//    @ExceptionHandler({BindException.class})
//    public ResponseEntity<Object> onBindingException(BindException e, Locale locale) {
////        String error = messageSource.getMessage(e.getMessage(), new Object[]{}, locale);
////        return new ResponseEntity<>(new MyMessage("errors_messager"), HttpStatus.BAD_REQUEST);
//        Map<String, String> errors = new HashMap<>();
//        for (FieldError error : e.getFieldErrors()) {
//            errors.put(error.getField(), error.getDefaultMessage());
//        }
////        return ResponseEntity.badRequest().body(
////                new RESTResponse.Error()
////                        .setMessage(messageSource.getMessage("Has.exception.handler", null, Locale.getDefault()))
////                        .setStatus(HttpStatus.BAD_REQUEST.value())
////                        .addErrors(errors)
////                        .build()
//        String abc = messageSource.getMessage(errors.get("errors_messager"), null, locale);
//        System.out.println(abc);
//        return new ResponseEntity<Object>(abc, HttpStatus.BAD_REQUEST);
//    }

//    private String resolveExceptionToMessage(Exception exceptio) {
//        //or put in map<Exceptio,String error.message.type1>
//        // String errorCode = map.get(excptio);
//        //eturn messageSource.getMessage(errorCode , new Object[]{},locale);
//        if (exceptio instanceof ....){
//            return messageSource.getMessage("error.message.type1", new Object[]{}, locale);
//        }
//        return "";
//    }

    @ExceptionHandler({BindException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> onBindException(BindException e, Locale locale) {
        Map<String, String> errors = new HashMap<>();
        for (FieldError error : e.getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }
        return ResponseEntity.badRequest().body(
                new MyMessage(messageSource.getMessage("errors_messager", null, locale)));
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> onMethodArgumentNotValidException(MethodArgumentNotValidException e, Locale locale) {
        Map<String, String> errors = new HashMap<>();
        for (FieldError error : e.getBindingResult().getFieldErrors()) {
            errors.put(error.getField(), messageSource.getMessage(error.getDefaultMessage(), null, locale));
        }


        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler({ConstraintViolationException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> onConstraintViolationException(ConstraintViolationException e, Locale locale) {
        Map<String, String> errors = new HashMap<>();
        for (ConstraintViolation<?> violation : e.getConstraintViolations()) {
            errors.put(violation.getPropertyPath().toString(), violation.getMessage());
        }
        return ResponseEntity.badRequest().body(
                new MyMessage(messageSource.getMessage("errors_mess1", null, locale)));
    }
}
