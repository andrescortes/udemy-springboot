package com.dev.university.university.service.implementation;

import com.dev.university.university.model.entities.Career;
import com.dev.university.university.model.entities.Person;
import com.dev.university.university.repository.PersonRepository;
import com.dev.university.university.repository.TeacherRepository;
import com.dev.university.university.service.contract.TeacherDAO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class TeacherDAOImpl extends PersonDAOImpl implements TeacherDAO {

    public TeacherDAOImpl(
        @Qualifier("teachersRepository") PersonRepository repository) {
        super(repository);
    }

    @Override
    public Iterable<Person> findTeacherByNameCareer(String career) {
        return ((TeacherRepository)repository).findTeacherByNameCareer(career);
    }


}

