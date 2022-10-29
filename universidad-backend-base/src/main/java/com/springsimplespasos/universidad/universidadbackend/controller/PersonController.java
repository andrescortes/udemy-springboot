package com.springsimplespasos.universidad.universidadbackend.controller;

import com.springsimplespasos.universidad.universidadbackend.exception.BadRequestException;
import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Persona;
import com.springsimplespasos.universidad.universidadbackend.servicios.contratos.PersonaDAO;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Deprecated
public class PersonController extends GenericController<Persona, PersonaDAO> {

    public PersonController(PersonaDAO service) {
        super(service);
        entityName = "Persona";
    }

    @GetMapping("/name-lastname")
    public ResponseEntity<?> findByNameAndLastname(
        @RequestParam(name = "name") String name,
        @RequestParam(name = "lastname") String lastname) {
        Map<String, Object> message = new HashMap<>();
        Optional<Persona> persona = service.buscarPorNombreYApellido(name, lastname);
        if (persona.isEmpty()) {
            //throw new BadRequestException(
            //String.format("No exist any %s with name %s and lastname %s", entityName, name,
            //lastname));
            message.put("Success", Boolean.FALSE);
            message.put("message",
                String.format("No exist any %s with name %s and lastname %s", entityName, name,
                    lastname));
            return ResponseEntity.badRequest().body(message);
        }
        message.put("Success", Boolean.TRUE);
        message.put("data", persona.get());
        return ResponseEntity.ok(message);
    }
}


