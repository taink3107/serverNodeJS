package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.io.Serializable;

@Embeddable
public class PersoncateID implements Serializable {
    @Column(name = "person_id",insertable=false, updatable=false, unique=true, nullable=false)
    Long PersonID;
    @Column(name = "category_id",insertable=false, updatable=false, unique=true, nullable=false)
    Long CategoryID;
}
