package com.example.demo.service;

import com.example.demo.domain.Category;
import com.example.demo.responsitory.CateRespon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CateRespon respon;

    public List<Category> findAll(Specification specification) {
        return respon.findAll();
    }

    public Category findOne(Long id) {
        return respon.findById(id).orElse(null);
    }

    public List<Category> getByPersonId(Long id) {
        return respon.getByPersonID(id);
    }

    public Category save(Category category) {
        return respon.save(category);
    }

    public Long totalCategory(Long id) {
        return respon.countByPersonId(id);
    }

}
