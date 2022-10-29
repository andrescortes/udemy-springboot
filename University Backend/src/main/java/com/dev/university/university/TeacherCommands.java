package com.dev.university.university;

import com.dev.university.university.model.entities.Address;
import com.dev.university.university.model.entities.Career;
import com.dev.university.university.model.entities.Person;
import com.dev.university.university.model.entities.Teacher;
import com.dev.university.university.repository.TeacherRepository;
import com.dev.university.university.service.contract.CareerDAO;
import com.dev.university.university.service.contract.PersonDAO;
import com.dev.university.university.service.contract.TeacherDAO;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TeacherCommands implements CommandLineRunner {

    private final PersonDAO personDAO;
    private final CareerDAO careerDAO;

    public TeacherCommands(@Qualifier("teacherDAOImpl") PersonDAO personDAO, CareerDAO careerDAO) {
        this.personDAO = personDAO;
        this.careerDAO = careerDAO;
    }


    @Override
    public void run(String... args) throws Exception {

        /*Optional<Career> career = careerDAO.findById(2);
        System.out.println("career = " + career);*/


        /*Address address = new Address("Street Fake 123", "Ciudad Pharma", "600", "Miami", "3",
            "Main Street");
        //public Teacher(Integer id, String name, String lastName, String dni, Address address,
        //        BigDecimal salary)

        Person teacher = new Teacher(null, "Carlos", "Valdemares", "22222", address,
            new BigDecimal(5500));
        ((Teacher) teacher).setCareers(
            new HashSet<>(Arrays.asList(career.get(), career2.get(), career3.get())));*/

        //Person save = personDAO.save(teacher);
        /*Person teacher = null;
        Optional<Person> teacher1 = personDAO.findById(4);
        System.out.println("teacher1 = " + teacher1.get());
        teacher = teacher1.get();
        System.out.println("Careers of teacher: ");
        ((Teacher)teacher).getCareers().forEach(System.out::println);
        System.out.println("End of careers of teacher");*/
        /*((Teacher) teacher).setCareers(new HashSet<>(List.of(career.get())));
        Person save = personDAO.save(teacher);
        System.out.println("saveTeacher = " + save.toString());*/

        /*Iterable<Person> teachers = ((TeacherDAO) personDAO).findTeacherByNameCareer(
            "System Engineer");
        System.out.println("teachers by name of career: ");
        teachers.forEach(System.out::println);*/
    }
}
