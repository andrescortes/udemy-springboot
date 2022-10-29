package com.dev.university.university.service.implementation;

import com.dev.university.university.model.entities.Person;
import com.dev.university.university.repository.PersonRepository;
import com.dev.university.university.repository.StudentRepository;
import com.dev.university.university.service.contract.StudentDAO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class StudentDAOImpl extends PersonDAOImpl implements StudentDAO {

    public StudentDAOImpl(@Qualifier("studentsRepository") PersonRepository repository) {
        super(repository);
    }

    @Override
    public Iterable<Person> findStudentByNameCareer(String career) {
        return ((StudentRepository)repository).findStudentByNameCareer(career);
    }
}


