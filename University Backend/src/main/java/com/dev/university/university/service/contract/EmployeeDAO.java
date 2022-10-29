package com.dev.university.university.service.contract;

import com.dev.university.university.model.entities.Person;
import com.dev.university.university.model.entities.enums.EmployeeType;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeDAO extends PersonDAO {

    @Query("select e from Employee e where e.employeeType IN :employeeType")
    Iterable<Person> findEmployeeByEmployeeType(EmployeeType employeeType);
}
