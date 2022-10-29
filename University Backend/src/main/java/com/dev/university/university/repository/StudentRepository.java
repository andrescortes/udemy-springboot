package com.dev.university.university.repository;

import com.dev.university.university.model.entities.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("studentsRepository")
public interface StudentRepository extends PersonRepository {
    @Query("select s from Student s join fetch s.career c where c.name = ?1")
    Iterable<Person> findStudentByNameCareer(String career);
}


