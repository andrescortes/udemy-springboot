package com.dev.university.university.service.contract;

import com.dev.university.university.model.entities.Pavilion;
import org.springframework.data.jpa.repository.Query;

public interface PavilionDAO extends GenericDAO<Pavilion> {

    @Query("select p from Pavilion  p join fetch p.address a where a.location = :location")
    Iterable<Pavilion> findPavilionByAddress_Location(String location);

    @Query("select p from Pavilion  p where p.name = :name")
    Iterable<Pavilion> findPavilionByName(String name);
}
