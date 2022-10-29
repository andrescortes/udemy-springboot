package com.dev.university.university.repository;

import com.dev.university.university.model.entities.Career;
import com.dev.university.university.model.entities.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("teachersRepository")
public interface TeacherRepository extends PersonRepository {

    @Query("select t from Teacher t join fetch t.careers c where c.name = ?1")
    Iterable<Person> findTeacherByNameCareer(String career);


}
