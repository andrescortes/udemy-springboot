package com.dev.university.university;

import com.dev.university.university.model.entities.Address;
import com.dev.university.university.model.entities.Career;
import com.dev.university.university.model.entities.Person;
import com.dev.university.university.model.entities.Student;
import com.dev.university.university.service.contract.CareerDAO;
import com.dev.university.university.service.contract.PersonDAO;
import com.dev.university.university.service.contract.StudentDAO;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StudentCommands implements CommandLineRunner {

    private final PersonDAO personDAO;
    private final CareerDAO careerDAO;

    //to add qualifier of service name lowercase to use the correct repository
    public StudentCommands(@Qualifier("studentDAOImpl") PersonDAO personDAO, CareerDAO careerDAO) {
        this.personDAO = personDAO;
        this.careerDAO = careerDAO;
    }

    @Override
    public void run(String... args) throws Exception {
        /*Optional<Career> systemEng = careerDAO.findById(2);
        System.out.println("systemEng = " + systemEng);
        Iterable<Person> students = personDAO.findAll();
        System.out.println("saving students: ");
        students.forEach(student -> {
            ((Student) student).setCareer(systemEng.get());
        });
        students.forEach(personDAO::save);
        System.out.println("students saved! ");*/

        /*Optional<Person> student1 = personDAO.findById(1);
        Optional<Career> systemEng = careerDAO.findById(2);*/
        /*
        Optional<Person> byNameAndLastName = personDAO.findByNameAndLastName(
            student1.get().getName(), student1.get().getLastName());
        System.out.println("Begin of students: ");
        System.out.println("byNameAndLastName = " + byNameAndLastName.toString());
        Optional<Person> byDni = personDAO.findByDni(student1.get().getDni());
        System.out.println("byDni = " + byDni.toString());
        Iterable<Person> byLastName = personDAO.findByLastName(student1.get().getLastName());
        System.out.println("byLastName = " + byLastName.toString());
        System.out.println("End of students");*/

        /*Iterable<Person> studentsByNameCareer = ((StudentDAO) personDAO).findStudentByNameCareer(
            systemEng.get().getName());

        System.out.println("Begin of students: ");
        studentsByNameCareer.forEach(System.out::println);
        System.out.println("End of students");*/
    }
}

