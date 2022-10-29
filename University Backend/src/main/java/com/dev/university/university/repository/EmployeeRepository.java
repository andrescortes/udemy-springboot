package com.dev.university.university.repository;

import com.dev.university.university.model.entities.Person;
import com.dev.university.university.model.entities.enums.EmployeeType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("employeesRepository")
public interface EmployeeRepository extends PersonRepository {

    @Query("select e from Employee e where e.employeeType IN :employeeType")
    Iterable<Person> findEmployeeByEmployeeType(EmployeeType employeeType);
}


