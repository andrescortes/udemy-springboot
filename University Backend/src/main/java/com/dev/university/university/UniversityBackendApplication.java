package com.dev.university.university;

import com.dev.university.university.service.contract.StudentDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UniversityBackendApplication {

    private final StudentDAO studentDAO;

    public UniversityBackendApplication(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    public static void main(String[] args) {
        String[] beanDefinitionNames = SpringApplication.run(UniversityBackendApplication.class,
            args).getBeanDefinitionNames();
        /*System.out.println("Bean Definitions: ");
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
        System.out.println("End of Bean Definitions");*/

    }

    @Bean
    public CommandLineRunner runner() {
        return args -> {
            /*Address address = new Address("123 Main St", "222", "9000", "", "", "Arizona");
            Person student = new Student(null, "Martin", "Romero", "1111111", address);
            Person save = studentDAO.save(student);
            System.out.println("Saved student: " + save.toString());*/

            /*List<Person> students = (List<Person>) studentDAO.findAll();
            System.out.println("Students: ");
            students.forEach(System.out::println);
            System.out.println("End of Students");*/
        };
    }

}
