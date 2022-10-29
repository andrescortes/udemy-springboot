package com.dev.university.university.service.implementation;

import com.dev.university.university.model.entities.Pavilion;
import com.dev.university.university.repository.PavilionRepository;
import com.dev.university.university.service.contract.PavilionDAO;
import org.springframework.stereotype.Service;

@Service
public class PavilionDAOImpl extends GenericDAOImpl<Pavilion, PavilionRepository> implements
    PavilionDAO {

    public PavilionDAOImpl(PavilionRepository repository) {
        super(repository);
    }

    @Override
    public Iterable<Pavilion> findPavilionByAddress_Location(String location) {
        return repository.findPavilionByAddress_Location(location);
    }

    @Override
    public Iterable<Pavilion> findPavilionByName(String name) {
        return repository.findPavilionByName(name);
    }
}


