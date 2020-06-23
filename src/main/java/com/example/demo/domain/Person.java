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


    public Person() {

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
