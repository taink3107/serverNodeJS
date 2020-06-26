package com.example.demo.responsitory;

import com.example.demo.domain.Person;
import com.sipios.springsearch.SearchCriteria;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public interface PersonRespon extends JpaRepository<Person, Long>, JpaSpecificationExecutor<Person>, CrudRepository<Person, Long> {
    @Query("select c from person c WHERE c.firstname = ?1 and c.status = ?2")
    List<Person> findAllX(String name, String status);
}
