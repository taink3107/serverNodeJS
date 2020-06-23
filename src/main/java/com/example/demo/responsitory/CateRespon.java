package com.example.demo.responsitory;

import com.example.demo.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface CateRespon extends JpaRepository<Category, Long>, JpaSpecificationExecutor<CateRespon> {
}
