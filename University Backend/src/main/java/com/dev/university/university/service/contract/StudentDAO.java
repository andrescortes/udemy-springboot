package com.dev.university.university.service.contract;

import com.dev.university.university.model.entities.Person;

public interface StudentDAO extends PersonDAO {
    Iterable<Person> findStudentByNameCareer(String lastName);
}
