package com.example.demo.responsitory;

import com.example.demo.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CateRespon extends JpaRepository<Category, Long>, JpaSpecificationExecutor<CateRespon>, CrudRepository<Category, Long> {
    @Query("select c from category c  WHERE  c.person.id = ?1")
    List<Category> getByPersonID(Long id);

    @Query("SELECT count(c) from category c WHERE c.person.id = ?1")
    Long countByPersonId(Long id);

}
