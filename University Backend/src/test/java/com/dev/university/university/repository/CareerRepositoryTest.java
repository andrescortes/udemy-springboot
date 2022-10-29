package com.dev.university.university.repository;

import com.dev.university.university.data.DataDummy;
import com.dev.university.university.model.entities.Career;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class CareerRepositoryTest {

    @Autowired
    private CareerRepository careerRepository;


    @BeforeEach
    void setUp() {
        //given
        careerRepository.save(DataDummy.career1());
        careerRepository.save(DataDummy.career2());
        careerRepository.save(DataDummy.career3());
    }

    @AfterEach
    void tearDown() {
        careerRepository.deleteAll();
    }

    @Test
    @DisplayName("Find careers by name")
    void findCareersByNameContains() {
        //when
        Iterable<Career> expected = careerRepository.findCareersByNameContains("System");

        //then
        Assertions.assertThat(((List<Career>) expected).size() == 2).isTrue();
    }

    @Test
    @Disabled
    void findCareersByNameContainsIgnoreCase() {
    }

    @Test
    @Disabled
    void findCareerByNumberOfYearsAfter() {
    }

    @Test
    @Disabled
    void findCareersByTeachersWithNameAndLastName() {
    }
}