package com.springsimplespasos.universidad.universidadbackend.controller;

import com.springsimplespasos.universidad.universidadbackend.exception.BadRequestException;
import com.springsimplespasos.universidad.universidadbackend.servicios.contratos.GenericoDAO;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@Deprecated
public class GenericController<E, S extends GenericoDAO<E>> {
    protected final S service;
    protected String entityName;

    public GenericController(S service) {
        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        Map<String, Object> message = new HashMap<>();

        List<E> entities = (List<E>) service.findAll();
        if (entities.isEmpty()) {
            //throw new BadRequestException(String.format("No exist any %s", entityName));
            message.put("Success", Boolean.FALSE);
            message.put("message", String.format("No exist any %s", entityName));
            return ResponseEntity.badRequest().body(message);
        }
        message.put("Success", Boolean.TRUE);
        message.put("data", entities);
        return ResponseEntity.ok(message);
    }

    //getEntityById(Id)

    //deleteEntityById(Id)

    //createEntity(Entity)

}
