package com.dev.university.university.service.implementation;

import com.dev.university.university.model.entities.Person;
import com.dev.university.university.model.entities.enums.EmployeeType;
import com.dev.university.university.repository.EmployeeRepository;
import com.dev.university.university.repository.PersonRepository;
import com.dev.university.university.service.contract.EmployeeDAO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class EmployeeDAOImpl extends PersonDAOImpl implements EmployeeDAO {

    public EmployeeDAOImpl(
        @Qualifier("employeesRepository") PersonRepository repository) {
        super(repository);
    }

    @Override
    public Iterable<Person> findEmployeeByEmployeeType(EmployeeType employeeType) {
        return ((EmployeeRepository)repository).findEmployeeByEmployeeType(employeeType);
    }
}


