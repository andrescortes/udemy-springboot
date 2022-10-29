package com.dev.university.university;

import com.dev.university.university.model.entities.Career;
import com.dev.university.university.service.contract.CareerDAO;
import java.util.List;
import java.util.Optional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CareerCommands implements CommandLineRunner {

    private final CareerDAO careerDAO;

    public CareerCommands(CareerDAO careerDAO) {
        this.careerDAO = careerDAO;
    }

    @Override
    public void run(String... args) throws Exception {
        //insert careers
        /*Career systemEng = new Career(null, "System Engineer", 50, 5);
        Career saveCareer = careerDAO.save(systemEng);
        System.out.println("Saving career: ");
        System.out.println(saveCareer);*/
        /*Career career1 = null;
        Optional<Career> career = careerDAO.findById(1);
        if (career.isPresent()) {
            System.out.println("Career found: ");
            career1 = career.get();
            System.out.println(career.get());
            System.out.println("End of career found");
        } else {
            System.out.println("Career not found");
        }

        //update careers
        assert career1 != null;
        career1.setNumberOfSubjects(65);
        career1.setNumberOfYears(6);
        careerDAO.save(career1);
        System.out.println("Instance of career updated: ");
        System.out.println(careerDAO.findById(1).orElse(new Career()));
        System.out.println("Deleting career: ");
        careerDAO.deleteById(1);
        System.out.println("End of deleting career");
        System.out.println("Careers empty: ");
        System.out.println(careerDAO.findById(1).orElse(new Career()));
        System.out.println("End of careers empty");*/

        //insert careers
        /*Career career1 = new Career(null, "System Engineer", 60, 6);
        Career career2 = new Career(null, "Industrial engineer ", 55, 5);
        Career career3 = new Career(null, "Food Engineer", 53, 5);
        Career career4 = new Career(null, "Electronic Engineer", 45, 5);
        Career career5 = new Career(null, "Tourism Engineer", 40, 4);
        Career career6 = new Career(null, "Resources Engineer", 25, 3);

        careerDAO.save(career1);
        careerDAO.save(career2);
        careerDAO.save(career3);
        careerDAO.save(career4);
        careerDAO.save(career5);
        careerDAO.save(career6);*/

        //search careers containing "Engineer"
        /*List<Career> careers = (List<Career>) careerDAO.findCareersByNameContains("Food");
        System.out.println("Careers containing 'Engineer': ");
        careers.forEach(System.out::println);
        System.out.println("End of careers containing 'Engineer'");*/

        //ignore case
        /*List<Career> careers = (List<Career>) careerDAO.findCareersByNameContainsIgnoreCase(
            "FOOD");
        List<Career> careers2 = (List<Career>) careerDAO.findCareersByNameContainsIgnoreCase(
            "food");
        System.out.println("Careers containing 'FOOD' ignoring case: ");
        careers.forEach(System.out::println);
        System.out.println("End of careers containing 'FOOD' ignoring case");
        System.out.println("Careers containing 'food' ignoring case: ");
        careers2.forEach(System.out::println);
        System.out.println("End of careers containing 'food' ignoring case");*/

        //search years > 5
        /*List<Career> careers = (List<Career>) careerDAO.findCareerByNumberOfYearsAfter(5);
        System.out.println("Careers with years > 5: ");
        careers.forEach(System.out::println);
        System.out.println("End of careers with years > 5");*/


    }
}
