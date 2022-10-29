package com.dev.university.university.repository;

import com.dev.university.university.model.entities.Classroom;
import com.dev.university.university.model.entities.enums.Pizzarra;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ClassroomRepository extends CrudRepository<Classroom, Integer> {

    @Query("select c from Classroom c where c.pizzarra IN :pizzarraType")
    Iterable<Classroom> findClassroomsByPizarraType(Pizzarra pizzarraType);


    @Query("select c from Classroom c join fetch c.pavilion p where p.name = :pavilionName")
    Iterable<Classroom> findClassroomsByPavilionName(String pavilionName);

    @Query("select c from Classroom c where c.classroomNumber = :classroomNumber")
    Classroom findClassroomByNumber(Integer classroomNumber);
}


