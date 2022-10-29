package com.dev.university.university.service.implementation;

import com.dev.university.university.model.entities.Classroom;
import com.dev.university.university.model.entities.enums.Pizzarra;
import com.dev.university.university.repository.ClassroomRepository;
import com.dev.university.university.service.contract.ClassroomDAO;
import org.springframework.stereotype.Service;

@Service
public class ClassroomDAOImpl extends GenericDAOImpl<Classroom, ClassroomRepository> implements
    ClassroomDAO {

    public ClassroomDAOImpl(ClassroomRepository repository) {
        super(repository);
    }

    @Override
    public Iterable<Classroom> findClassroomsByPizarraType(Pizzarra pizzarraType) {
        return repository.findClassroomsByPizarraType(pizzarraType);
    }

    @Override
    public Iterable<Classroom> findClassroomsByPavilionName(String pavilionName) {
        return repository.findClassroomsByPavilionName(pavilionName);
    }

    @Override
    public Classroom findClassroomByNumber(Integer classroomNumber) {
        return repository.findClassroomByNumber(classroomNumber);
    }
}


