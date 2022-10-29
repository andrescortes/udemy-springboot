package com.dev.university.university.model.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name = "careers")
public class Career implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, unique = true, length = 80)
    private String name;
    @Column(name = "amount_subjects")
    private Integer numberOfSubjects;
    @Column(name = "amount_years")
    private Integer numberOfYears;
    @Column(name = "date_discharge")
    private LocalDate dischargeDate;
    @Column(name = "date_update")
    private LocalDate dateUpdate;
    @OneToMany(
        mappedBy = "career",
        fetch = FetchType.LAZY
    )
    private Set<Student> students;
    @ManyToMany(
        mappedBy = "careers",
        fetch = FetchType.LAZY
    )
    private Set<Teacher> teachers;

    public Career() {
    }

    public Career(Integer id, String name, Integer numberOfSubjects, Integer numberOfYears) {
        this.id = id;
        this.name = name;
        this.numberOfSubjects = numberOfSubjects;
        this.numberOfYears = numberOfYears;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumberOfSubjects() {
        return numberOfSubjects;
    }

    public void setNumberOfSubjects(Integer numberOfSubjects) {
        this.numberOfSubjects = numberOfSubjects;
    }

    public Integer getNumberOfYears() {
        return numberOfYears;
    }

    public void setNumberOfYears(Integer numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    public LocalDate getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(LocalDate dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    public LocalDate getDateLastUpdate() {
        return dateUpdate;
    }

    public void setDateLastUpdate(LocalDate dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }

    @PrePersist// before save to database update dischargeDate with current date
    private void beforePersist() {
        this.dischargeDate = LocalDate.now();
    }

    @PreUpdate // before update to database updateDate update with current date
    private void beforeUpdate() {
        this.dateUpdate = LocalDate.now();
    }

    @Override
    public String toString() {
        return "Career{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", numberOfSubjects=" + numberOfSubjects +
            ", numberOfYears=" + numberOfYears +
            ", dischargeDate=" + dischargeDate +
            ", dateUpdate=" + dateUpdate +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Career)) {
            return false;
        }
        Career career = (Career) o;
        return getId().equals(career.getId()) && getName().equals(career.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }
}
