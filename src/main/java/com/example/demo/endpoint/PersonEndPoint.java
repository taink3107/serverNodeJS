package com.example.demo.endpoint;

import com.example.demo.domain.Person;
import com.example.demo.APIconfig.PersonSpecificationsBuilder;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping(value = "/api_v1/person")
@CrossOrigin(value = "*")
public class PersonEndPoint {
    @Autowired
    PersonService personService;

    @GetMapping
    public List<Person> persons(@RequestParam("search") String search) {
        PersonSpecificationsBuilder builder = new PersonSpecificationsBuilder();
        Pattern pattern = Pattern.compile("(\\w+?)(:)(\\w+?),");
        Matcher matcher = pattern.matcher(search + ",");
        while (matcher.find()) {
            builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
        }
        Specification<Person> spec = builder.build();
        return personService.getAll(spec);
    }

    @GetMapping(value = "/{id}")
    public Person getPerson(@PathVariable("id") @Validated Long id) {
        return personService.getOne(id);
    }

    @PostMapping(value = "/save")
    public Person savePerson(@RequestBody Person person) {
        System.out.println(person.toString());
        return personService.savePerson(person);
    }

}
