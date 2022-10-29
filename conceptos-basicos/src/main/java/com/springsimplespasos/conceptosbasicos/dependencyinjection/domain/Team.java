package com.springsimplespasos.conceptosbasicos.dependencyinjection.domain;

import java.time.LocalDate;

public class Team {

    private Integer id;
    private String name;
    private Integer year;
    private LocalDate foundationYear;

    public Team() {
    }

    public Team(Integer id, String name, Integer year, LocalDate foundationYear) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.foundationYear = foundationYear;

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

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public LocalDate getFoundationYear() {
        return foundationYear;
    }

    public void setFoundationYear(LocalDate foundationYear) {
        this.foundationYear = foundationYear;
    }

    @Override
    public String toString() {
        return "Team{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", year=" + year +
            ", foundationYear=" + foundationYear +
            '}';
    }
}
