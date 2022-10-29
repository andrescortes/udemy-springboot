package com.dev.university.university.service.implementation;

import com.dev.university.university.model.entities.Career;
import com.dev.university.university.repository.CareerRepository;
import com.dev.university.university.service.contract.CareerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CareerDAOImpl extends GenericDAOImpl<Career, CareerRepository> implements CareerDAO {

    @Autowired
    public CareerDAOImpl(CareerRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Career> findCareersByNameContains(String name) {
        return repository.findCareersByNameContains(name);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Career> findCareersByNameContainsIgnoreCase(String name) {
        return repository.findCareersByNameContainsIgnoreCase(name);
    }

    @Override
    public Iterable<Career> findCareerByNumberOfYearsAfter(Integer years) {
        return repository.findCareerByNumberOfYearsAfter(years);
    }

    @Override
    public Iterable<Career> findCareersByTeachersWithNameAndLastName(String name, String lastName) {
        return repository.findCareersByTeachersWithNameAndLastName(name, lastName);
    }


}


