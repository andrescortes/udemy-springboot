package com.springsimplespasos.universidad.universidadbackend.controller;

import com.springsimplespasos.universidad.universidadbackend.exception.BadRequestException;
import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Alumno;
import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Carrera;
import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Persona;
import com.springsimplespasos.universidad.universidadbackend.servicios.contratos.CarreraDAO;
import com.springsimplespasos.universidad.universidadbackend.servicios.contratos.PersonaDAO;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Deprecated
@RestController
@RequestMapping("/students")
@ConditionalOnProperty(prefix = "app", name = "controller.enable-dto", havingValue = "false")
public class StudentControllerImpl extends PersonController {


    private final CarreraDAO carreraDAO;

    public StudentControllerImpl(@Qualifier("alumnoDAOImpl") PersonaDAO studentDAO,
        CarreraDAO carreraDAO) {
        super(studentDAO);
        entityName = "Student";
        this.carreraDAO = carreraDAO;
    }

    /*@GetMapping("/all")
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
    }*/


    @PostMapping("/create")
    public Persona createStudent(@RequestBody Persona student) {
        return service.save(student);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateStudent(
        @PathVariable(name = "id") Integer id,
        @RequestBody Persona student) {

        Map<String, Object> message = new HashMap<>();
        Persona studentToUpdate = null;
        Optional<Persona> studentOptional = service.findById(id);
        if (studentOptional.isEmpty()) {
            //throw new BadRequestException(String.format("No exist any student with id %d", id));
            message.put("Success", Boolean.FALSE);
            message.put("message", String.format("No exist any student with id %d", id));
            return ResponseEntity.badRequest().body(message);
        }
        studentToUpdate = studentOptional.get();
        studentToUpdate.setNombre(student.getNombre());
        studentToUpdate.setApellido(student.getApellido());
        studentToUpdate.setDni(student.getDni());
        studentToUpdate.setDireccion(student.getDireccion());
        message.put("data", service.save(studentToUpdate));
        message.put("Success", Boolean.TRUE);
        return ResponseEntity.ok(message);
    }

    /*@DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable(name = "id") Integer id) {
        Optional<Persona> studentOptional = studentDAO.findById(id);
        if (studentOptional.isEmpty()) {
            throw new BadRequestException(String.format("No exist any student with id %d", id));
        }
        studentDAO.deleteById(id);
    }*/

    @PutMapping("/{idStudent}/career/{idCareer}")
    public ResponseEntity<?> assignCareerToStudent(
        @PathVariable(name = "idStudent") Integer idStudent,
        @PathVariable(name = "idCareer") Integer idCareer) {

        Map<String, Object> message = new HashMap<>();
        Optional<Persona> studentOptional = service.findById(idStudent);
        if (studentOptional.isEmpty()) {
            //throw new BadRequestException(
            //String.format("No exist any student with id %d", idStudent));
            message.put("Success", Boolean.FALSE);
            message.put("message", String.format("No exist any student with id %d", idStudent));
            return ResponseEntity.badRequest().body(message);
        }
        Optional<Carrera> careerOptional = carreraDAO.findById(idCareer);
        if (careerOptional.isEmpty()) {
            //throw new BadRequestException(
            //String.format("No exist any career with id %d", idCareer));
            message.put("Success", Boolean.FALSE);
            message.put("message", String.format("No exist any career with id %d", idCareer));
            return ResponseEntity.badRequest().body(message);
        }

        Alumno student = (Alumno) studentOptional.get();
        Carrera carrera = careerOptional.get();
        student.setCarrera(carrera);

        message.put("data", service.save(student));
        message.put("Success", Boolean.TRUE);
        return ResponseEntity.ok(message);

    }

}

