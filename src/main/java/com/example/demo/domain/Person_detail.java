package com.example.demo.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity(name = "person_cate")
public class Person_detail implements Serializable {
    @EmbeddedId
    private PersoncateID personcateID;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "person_id", nullable = false, insertable = false, updatable = false)
    private Person person;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", nullable = false, insertable = false, updatable = false)
    private Category category;

    public Person_detail() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person_detail that = (Person_detail) o;
        return Objects.equals(personcateID, that.personcateID) &&
                Objects.equals(person, that.person) &&
                Objects.equals(category, that.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personcateID, person, category);
    }
}
