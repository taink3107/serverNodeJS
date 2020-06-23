package com.example.demo.endpoint;

import com.example.demo.domain.Category;
import com.example.demo.domain.Person;
import com.example.demo.service.CategoryService;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


@RestController
@RequestMapping("/api_v1/cate")
@CrossOrigin("*")
public class CateEndPoint {
    @Autowired
    CategoryService service;

    @GetMapping
    public ResponseEntity<List<Category>> responseEntity() {
        List<Category> categories = service.findAll();
        ResponseEntity<List<Category>> entity = new ResponseEntity<List<Category>>(categories, HttpStatus.OK);
        return entity;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> responseEntityById(@PathVariable Long id) {
        // List<Category> categories = service.getByPersonId(id);
        Category category = new Category();
        category.setId(1L);
        category.setName("Haha");
        Person p = new Person();
        p.setId(1L);
        p.setFirstname("Tai");
        p.setLastname("Haha");
        Date date = new Date(12344345654654L);
        p.setAge(20);
        p.setDob(date);
        category.setPerson(p);
        return new ResponseEntity<Category>(category, HttpStatus.OK);
    }
}
