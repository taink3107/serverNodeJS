package com.example.demo.service;

import com.example.demo.domain.Category;
import com.example.demo.responsitory.CateRespon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CategoryService {
    @Autowired
    CateRespon respon;

    public List<Category> findAll() {
        return respon.findAll();
    }

    public Category findOne(Long id) {
        return respon.findById(id).orElse(null);
    }

}
