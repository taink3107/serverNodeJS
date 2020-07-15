package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Component
@Data
@AllArgsConstructor
public class MyMessage {
    private String message;
    private List<String> messages;
    @Autowired
    @Qualifier("messconfig")
    MessageSource messageSource;

    public MyMessage() {
        this.messages = new ArrayList<>();
    }

    public MyMessage(List<String> messages) {
        this.messages = messages;
    }

    public MyMessage(String message) {
        this.message = message;
    }

    public void addMess(String message) {
        this.messages.add(message);
    }

    public List<String> getAllMess(Locale locale) {
        return this.messages.stream().map(s -> messageSource.getMessage(s, null, locale)).collect(Collectors.toList());
    }

    public String get1Mess(Locale locale) {
        return this.messageSource.getMessage(messages.get(0), null, locale);
    }
}
