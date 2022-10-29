package com.dev.university.university.repository;

import com.dev.university.university.model.entities.Person;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
//this annotation is used but no a generated repository beans, but is used to class inheritance
public interface PersonRepository extends CrudRepository<Person, Integer> {

    @Query("select p from Person p where p.name = ?1 and p.lastName = ?2")
    Optional<Person> findByNameAndLastName(String name, String lastName);

    @Query("select p from Person p where p.dni = ?1")
    Optional<Person> findByDni(String dni);

    @Query("select p from Person p where p.lastName like %?1%")
    Iterable<Person> findByLastName(String lastName);

}


