package com.dev.university.university.model.entities;

import java.math.BigDecimal;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "teachers")
@PrimaryKeyJoinColumn(name = "person_id")
public class Teacher extends Person {

    private BigDecimal salary;

    @ManyToMany(
        fetch = FetchType.LAZY,
        cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
        }
    )
    @JoinTable(
        name = "teacher_course",
        joinColumns = @JoinColumn(name = "teacher_id"),
        inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private Set<Career> careers;

    public Teacher() {
    }

    public Teacher(Integer id, String name, String lastName, String dni, Address address,
        BigDecimal salary) {
        super(id, name, lastName, dni, address);
        this.salary = salary;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Set<Career> getCareers() {
        return careers;
    }

    public void setCareers(Set<Career> careers) {
        this.careers = careers;
    }

    @Override
    public String toString() {
        return super.toString() +
            "\t Teacher{" +
            "salary=" + salary +
            ", careers=" + careers +
            '}';
    }
}
