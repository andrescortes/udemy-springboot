package com.dev.university.university.service.contract;

import com.dev.university.university.model.entities.Person;
import java.util.Optional;

public interface PersonDAO extends GenericDAO<Person> {

    Optional<Person> findByNameAndLastName(String name, String lastName);

    Optional<Person> findByDni(String dni);

    Iterable<Person> findByLastName(String lastName);
}
