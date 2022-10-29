package com.springsimplespasos.universidad.universidadbackend.controller.dto;

import com.springsimplespasos.universidad.universidadbackend.servicios.contratos.GenericoDAO;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import org.springframework.validation.BindingResult;

@AllArgsConstructor
public class GenericDTOController<E, S extends GenericoDAO<E>> {

    protected final S service;
    protected final String nameEntity;

    public List<E> getAllEntities() {
        return (List<E>) service.findAll();
    }

    public E getEntityById(Integer id) {
        return (E) service.findById(id);
    }

    public E createEntity(E entity) {
        return service.save(entity);
    }

    protected Map<String, Object> getValidations(BindingResult result) {
        Map<String, Object> validations = new HashMap<>();
        result.getFieldErrors().forEach(error -> {
            validations.put(error.getField(), error.getDefaultMessage());
        });
        return validations;
    }
}