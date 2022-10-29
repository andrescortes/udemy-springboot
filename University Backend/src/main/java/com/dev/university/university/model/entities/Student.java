package com.dev.university.university.model.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "students")
@PrimaryKeyJoinColumn(name = "person_id")
public class Student extends Person {
    @ManyToOne(
        optional = true,
        fetch = FetchType.LAZY,
        cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
        }
    )
    @JoinColumn(
        name = "career_id"
    )
    private Career career;
    public Student() {
    }

    public Student(Integer id, String name, String lastName, String dni, Address address) {
        super(id, name, lastName, dni, address);
    }

    public Career getCareer() {
        return career;
    }

    public void setCareer(Career career) {
        this.career = career;
    }

    @Override
    public String toString() {
        return super.toString() +
            "\t Student{" +
            "career=" + career +
            '}';
    }
}
