package com.springsimplespasos.universidad.universidadbackend.controller;

import com.springsimplespasos.universidad.universidadbackend.exception.BadRequestException;
import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Alumno;
import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Carrera;
import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Persona;
import com.springsimplespasos.universidad.universidadbackend.servicios.contratos.CarreraDAO;
import com.springsimplespasos.universidad.universidadbackend.servicios.contratos.PersonaDAO;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//@RequestMapping("/students")
@Deprecated
public class StudentController {

    private final PersonaDAO studentDAO;
    private final CarreraDAO carreraDAO;

    public StudentController(@Qualifier("alumnoDAOImpl") PersonaDAO studentDAO,
        CarreraDAO carreraDAO) {
        this.studentDAO = studentDAO;
        this.carreraDAO = carreraDAO;
    }

    @GetMapping("/all")
    public List<Persona> getAllStudents() {
        List<Persona> students = (List<Persona>) studentDAO.findAll();
        if (students.isEmpty()) {
            throw new BadRequestException("No exist any student");
        }
        return students;
    }

    @GetMapping("/{id}")
    public Persona getStudent(@PathVariable(name = "id") Integer id) {
        Optional<Persona> student = studentDAO.findById(id);
        if (student.isEmpty()) {
            throw new BadRequestException(String.format("No exist any career with id %d", id));
        }
        return student.get();
    }


    @PostMapping("/create")
    public Persona createStudent(@RequestBody Persona student) {
        return studentDAO.save(student);
    }

    @PutMapping("/update/{id}")
    public Persona updateStudent(
        @PathVariable(name = "id") Integer id,
        @RequestBody Persona student) {
        Persona studentToUpdate = null;
        Optional<Persona> studentOptional = studentDAO.findById(id);
        System.out.println("studentOptional = " + studentOptional.toString());
        if (studentOptional.isEmpty()) {
            throw new BadRequestException(String.format("No exist any student with id %d", id));
        }
        studentToUpdate = studentOptional.get();
        studentToUpdate.setNombre(student.getNombre());
        studentToUpdate.setApellido(student.getApellido());
        studentToUpdate.setDni(student.getDni());
        studentToUpdate.setDireccion(student.getDireccion());

        return studentDAO.save(studentToUpdate);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable(name = "id") Integer id) {
        Optional<Persona> studentOptional = studentDAO.findById(id);
        if (studentOptional.isEmpty()) {
            throw new BadRequestException(String.format("No exist any student with id %d", id));
        }
        studentDAO.deleteById(id);
    }

    @PutMapping("/{idStudent}/career/{idCareer}")
    public Persona assignCareerToStudent(
        @PathVariable(name = "idStudent") Integer idStudent,
        @PathVariable(name = "idCareer") Integer idCareer) {

        Optional<Persona> studentOptional = studentDAO.findById(idStudent);
        if (studentOptional.isEmpty()) {
            throw new BadRequestException(
                String.format("No exist any student with id %d", idStudent));
        }
        Optional<Carrera> careerOptional = carreraDAO.findById(idCareer);
        if (careerOptional.isEmpty()) {
            throw new BadRequestException(
                String.format("No exist any career with id %d", idCareer));
        }

        Alumno student = (Alumno) studentOptional.get();
        Carrera carrera = careerOptional.get();
        student.setCarrera(carrera);
        return studentDAO.save(student);

    }

}
