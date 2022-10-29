package com.dev.university.university.service.implementation;

import com.dev.university.university.model.entities.Person;
import com.dev.university.university.repository.PersonRepository;
import com.dev.university.university.service.contract.PersonDAO;
import java.util.Optional;
import org.springframework.transaction.annotation.Transactional;

public class PersonDAOImpl extends GenericDAOImpl<Person, PersonRepository> implements PersonDAO {

    public PersonDAOImpl(PersonRepository repository) {
        super(repository);
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<Person> findByNameAndLastName(String name, String lastName) {
        return repository.findByNameAndLastName(name, lastName);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Person> findByDni(String dni) {
        return repository.findByDni(dni);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Person> findByLastName(String lastName) {
        return repository.findByLastName(lastName);
    }
}


