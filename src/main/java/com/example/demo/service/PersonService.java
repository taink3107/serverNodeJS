package com.example.demo.service;

import com.example.demo.domain.Person;
import com.example.demo.responsitory.PersonRespon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    PersonRespon respon;

    public List<Person> getAll(Specification<Person> specs) {
        return respon.findAll(specs);
    }

    public Person getOne(Long id) {
        return respon.findById(id).orElse(null);
    }

    public Person savePerson(Person person) {
        return respon.save(person);
    }
}
