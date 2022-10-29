package com.dev.university.university.service.contract;

import com.dev.university.university.model.entities.Career;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;

public interface CareerDAO extends GenericDAO<Career> {

    //@Query("select c from Career c where c.name like %?1%")
    Iterable<Career> findCareersByNameContains(String name);

    //@Query("select c from Career c where upper(c.name) like upper(?1)")
    Iterable<Career> findCareersByNameContainsIgnoreCase(String name);

    //@Query("select c from Career c where c.numberOfYears > ?1")
    Iterable<Career> findCareerByNumberOfYearsAfter(Integer years);

    @Query("select c from Career c join fetch c.teachers t where t.name = ?1 and t.lastName = ?2")
    Iterable<Career> findCareersByTeachersWithNameAndLastName(String name, String lastName);
}

