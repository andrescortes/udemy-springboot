package com.dev.university.university.service.contract;

import com.dev.university.university.model.entities.Career;
import com.dev.university.university.model.entities.Person;
import org.springframework.data.jpa.repository.Query;

public interface TeacherDAO extends PersonDAO {

    @Query("select t from Teacher t join fetch t.careers c where c.name = ?1")
    Iterable<Person> findTeacherByNameCareer(String career);


}


