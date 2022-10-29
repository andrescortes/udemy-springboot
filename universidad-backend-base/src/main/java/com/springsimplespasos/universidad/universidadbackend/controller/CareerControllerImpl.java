package com.springsimplespasos.universidad.universidadbackend.controller;

import com.springsimplespasos.universidad.universidadbackend.exception.BadRequestException;
import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Carrera;
import com.springsimplespasos.universidad.universidadbackend.servicios.contratos.CarreraDAO;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Deprecated//The controller is deprecated because it is not used anymore, but it is kept for future use.
@RestController
@RequestMapping("/careers")
@ConditionalOnProperty(prefix = "app",name = "controller.enable-dto", havingValue = "false")
public class CareerControllerImpl extends GenericController<Carrera, CarreraDAO> {

    public CareerControllerImpl(CarreraDAO service) {
        super(service);
        entityName = "Career";
    }

/*    @GetMapping("/{id}")
    public Carrera getCarreraById(@PathVariable(value = "id", required = true) Integer id) {
        Optional<Carrera> carrera = service.findById(id);
        if (carrera.isEmpty()) {
            throw new BadRequestException(String.format("No exist any career with id %d", id));
        }
        return carrera.get();
    }*/

    /*@PostMapping("/createEntity")
    public Carrera createCarrera(@RequestBody Carrera carrera) {
        if (carrera.getCantidadAnios() < 0) {
            throw new BadRequestException("The quantity of years must be greater than 0");
        }
        if (carrera.getCantidaMaterias() < 0) {
            throw new BadRequestException("The quantity of subjects must be greater than 0");
        }
        return service.save(carrera);
    }*/

    @PostMapping("/create")
    public ResponseEntity<?> createCarrera(@Valid @RequestBody Carrera carrera,
        BindingResult result) {

        Map<String, Object> validations = new HashMap<>();
        if (result.hasErrors()) {
            result.getFieldErrors().forEach(error -> {
                validations.put(error.getField(), error.getDefaultMessage());
            });
            validations.put("Success", Boolean.FALSE);
            return ResponseEntity.badRequest().body(validations);
        }
        validations.put("data", service.save(carrera));
        validations.put("Success", Boolean.TRUE);
        return ResponseEntity.ok(validations);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCareer(
        @PathVariable(name = "id") Integer id,
        @RequestBody Carrera carrera) {

        Map<String, Object> message = new HashMap<>();
        Optional<Carrera> career = service.findById(id);
        if (career.isEmpty()) {
            //throw new BadRequestException(String.format("No exist any career with id %d", id));
            message.put("Success", Boolean.FALSE);
            message.put("message", String.format("No exist any career with id %d", id));
            return ResponseEntity.badRequest().body(message);
        }
        if (carrera.getCantidadAnios() < 0) {
            //throw new BadRequestException("The quantity of years must be greater than 0");
            message.put("Success", Boolean.FALSE);
            message.put("message",
                String.format("The quantity of years must be greater than 0 in %s", entityName));
            return ResponseEntity.badRequest().body(message);
        }
        if (carrera.getCantidaMaterias() < 0) {
            //throw new BadRequestException("The quantity of subjects must be greater than 0");
            message.put("Success", Boolean.FALSE);
            message.put("message",
                String.format("The quantity of subjects must be greater than 0 in %s", entityName));
            return ResponseEntity.badRequest().body(message);
        }
        Carrera careerToEdit = null;

        careerToEdit = career.get();
        careerToEdit.setNombre(carrera.getNombre());
        careerToEdit.setCantidaMaterias(carrera.getCantidaMaterias());
        careerToEdit.setCantidadAnios(carrera.getCantidadAnios());

        message.put("data", service.save(careerToEdit));
        message.put("Success", Boolean.TRUE);
        return ResponseEntity.ok(message);
    }

/*    @DeleteMapping("/delete/{id}")
    public void deleteCarrera(@PathVariable(value = "id", required = true) Integer id) {
        Optional<Carrera> carrera = service.findById(id);
        if (carrera.isEmpty()) {
            throw new BadRequestException(String.format("No exist any career with id %d", id));
        }
        service.deleteById(carrera.get().getId());
    }*/

}