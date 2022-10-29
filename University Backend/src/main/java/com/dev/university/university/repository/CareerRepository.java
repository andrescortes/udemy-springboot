package com.dev.university.university.repository;

import com.dev.university.university.model.entities.Career;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository//optional due to the fact that we are using the JPA implementation
public interface CareerRepository extends CrudRepository<Career, Integer> {

    //@Query("select c from Career c where c.name like %?1%")
    Iterable<Career> findCareersByNameContains(String name);

    //@Query("select c from Career c where upper(c.name) like upper(?1)")
    Iterable<Career> findCareersByNameContainsIgnoreCase(String name);

    //@Query("select c from Career c where c.numberOfYears > ?1")
    Iterable<Career> findCareerByNumberOfYearsAfter(Integer years);

    @Query("select c from Career c join fetch c.teachers t where t.name = ?1 and t.lastName = ?2")
    Iterable<Career> findCareersByTeachersWithNameAndLastName(String name, String lastName);

}


