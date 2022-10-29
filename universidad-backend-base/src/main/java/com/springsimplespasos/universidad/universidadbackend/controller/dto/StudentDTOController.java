package com.springsimplespasos.universidad.universidadbackend.controller.dto;

import com.springsimplespasos.universidad.universidadbackend.modelo.dto.PersonDTO;
import com.springsimplespasos.universidad.universidadbackend.modelo.dto.StudentDTO;
import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Alumno;
import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Persona;
import com.springsimplespasos.universidad.universidadbackend.modelo.mapper.mapstruct.StudentMapper;
import com.springsimplespasos.universidad.universidadbackend.servicios.contratos.PersonaDAO;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
@ConditionalOnProperty(prefix = "app", name = "controller.enable-dto", havingValue = "true")
public class StudentDTOController extends PersonDTOController {


    public StudentDTOController(PersonaDAO service, StudentMapper studentMapper) {
        super(service, "Student", studentMapper);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable(name = "id") Integer id) {

        Map<String, Object> validations = new HashMap<>();
        //Optional<Persona> studentDAOById = studentDAO.findById(id);
        /*if (studentDAOById.isEmpty()) {
            validations.put("message", String.format("No found student with id %d", id));
            validations.put("Success", Boolean.FALSE);
            return ResponseEntity.badRequest().body(validations);
        }
        PersonDTO studentDTO = studentMapper.mapStudent((Alumno) studentDAOById.get());
        validations.put("data", studentDTO);*/
        validations.put("Success", Boolean.TRUE);
        return ResponseEntity.ok(validations);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createStudent(
        @Valid @RequestBody PersonDTO studentDTO,
        BindingResult result) {
        Map<String, Object> message = new HashMap<>();
        if (result.hasErrors()) {
            /*Map<String, Object> validations = new HashMap<>();
            result.getFieldErrors()
                .forEach(error -> validations.put(error.getField(), error.getDefaultMessage()));*/
            message.put("Message", super.getValidations(result));
            message.put("Success", Boolean.FALSE);
            return ResponseEntity.badRequest().body(message);
        }
//        PersonDTO save = studentDAO.save(studentMapper.mapStudent((StudentDTO) studentDTO));
        PersonDTO save = super.createPerson(studentMapper.mapStudent((StudentDTO) studentDTO));
        message.put("data", save);
        message.put("Success", Boolean.TRUE);
        return ResponseEntity.status(HttpStatus.CREATED).body(message);
    }
}
