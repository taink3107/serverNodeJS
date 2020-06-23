package com.example.demo.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.*;

@Data
@Entity(name = "person")
@Component
@Table(name = "person")
public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "first_name")
    private String firstname;
    @Column(name = "last_name")
    private String lastname;
    @Column(name = "age")
    private int age;
    @Column(name = "salary")
    private double salary;
    @Column(name = "dob")
    private Date dob;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(mappedBy = "person")
    private List<Person_detail> person_details;

    public Person() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Double.compare(person.salary, salary) == 0 &&
                Objects.equals(id, person.id) &&
                Objects.equals(firstname, person.firstname) &&
                Objects.equals(lastname, person.lastname) &&
                Objects.equals(dob, person.dob) &&
                status == person.status &&
                Objects.equals(person_details, person.person_details);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname, age, salary, dob, status, person_details);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", dob=" + dob +
                ", status=" + status +
                '}';
    }
}
