package com.example.demo.endpoint;

import com.example.demo.domain.Category;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Validated
@RestController
@RequestMapping("/api_v1/cate")
@CrossOrigin("*")
public class CateEndPoint {
    @Autowired
    CategoryService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<List<Category>> responseEntityById(@PathVariable Long id) {
        List<Category> list = service.getByPersonId(id);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<Category> save(@RequestBody @Valid Category category) {
        return new ResponseEntity<>(service.save(category), HttpStatus.OK);
    }

    @PostMapping(value = "/exist/{id}")
    public ResponseEntity<Long> getTotalCategory(@PathVariable Long id) {
        Long id2 = service.totalCategory(id);
        return new ResponseEntity<>(id2, HttpStatus.OK);
    }
}
