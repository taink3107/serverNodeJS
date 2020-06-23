package com.example.demo.endpoint;

import com.example.demo.domain.Category;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
