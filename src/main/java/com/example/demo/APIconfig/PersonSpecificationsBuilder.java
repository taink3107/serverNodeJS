package com.example.demo.APIconfig;

import com.example.demo.domain.Person;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class PersonSpecificationsBuilder {
    private final List<SearchCriteria> params;

    public PersonSpecificationsBuilder() {
        params = new ArrayList<SearchCriteria>();
    }

    public PersonSpecificationsBuilder with(String key, String operation, Object value) {
        if (key.equalsIgnoreCase("status")) {
            value = String.valueOf(value);
            System.out.println(value);
        }
        params.add(new SearchCriteria(key, operation, value));
        return this;
    }

    public Specification<Person> build() {
        if (params.size() == 0) {
            return null;
        }

        List<Specification> specs = params.stream()
                .map(PersonSpecification::new)
                .collect(Collectors.toList());

        Specification result = specs.get(0);
        for (int i = 1; i < params.size(); i++) {
            System.out.println(specs.get(i));
            result = Specification.where(result).and(specs.get(i));
        }
        return result;
    }
}
