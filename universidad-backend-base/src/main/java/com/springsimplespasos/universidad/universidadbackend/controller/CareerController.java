package com.springsimplespasos.universidad.universidadbackend.controller;

import com.springsimplespasos.universidad.universidadbackend.exception.BadRequestException;
import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Carrera;
import com.springsimplespasos.universidad.universidadbackend.servicios.contratos.CarreraDAO;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//@RequestMapping("/careers")
public class CareerController {

    private final CarreraDAO carreraDAO;

    public CareerController(CarreraDAO carreraDAO) {
        this.carreraDAO = carreraDAO;
    }

    @GetMapping("/all")
    public List<Carrera> getAllCareers() {
        List<Carrera> carreers = (List<Carrera>) carreraDAO.findAll();
        if (carreers.isEmpty()) {
            throw new BadRequestException("No exist any career");
        }
        return carreers;
    }

    @GetMapping("/{id}")
    public Carrera getCarreraById(@PathVariable(value = "id", required = true) Integer id) {
        Optional<Carrera> carrera = carreraDAO.findById(id);
        if (carrera.isEmpty()) {
            throw new BadRequestException(String.format("No exist any career with id %d", id));
        }
        return carrera.get();
    }

    @PostMapping("/create")
    public Carrera createCarrera(@RequestBody Carrera carrera) {
        if (carrera.getCantidadAnios() < 0) {
            throw new BadRequestException("The quantity of years must be greater than 0");
        }
        if (carrera.getCantidaMaterias() < 0) {
            throw new BadRequestException("The quantity of subjects must be greater than 0");
        }
        return carreraDAO.save(carrera);
    }

    @PutMapping("/update/{id}")
    public Carrera updateCareer(
        @PathVariable(name = "id") Integer id,
        @RequestBody Carrera carrera) {
        if (carrera.getCantidadAnios() < 0) {
            throw new BadRequestException("The quantity of years must be greater than 0");
        }
        if (carrera.getCantidaMaterias() < 0) {
            throw new BadRequestException("The quantity of subjects must be greater than 0");
        }
        Carrera careerToEdit;
        Optional<Carrera> career = carreraDAO.findById(id);
        if (career.isEmpty()) {
            throw new BadRequestException(String.format("No exist any career with id %d", id));
        }
        careerToEdit = career.get();
        careerToEdit.setNombre(carrera.getNombre());
        careerToEdit.setCantidaMaterias(carrera.getCantidaMaterias());
        careerToEdit.setCantidadAnios(carrera.getCantidadAnios());
        return carreraDAO.save(careerToEdit);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCarrera(@PathVariable(value = "id", required = true) Integer id) {
        Optional<Carrera> carrera = carreraDAO.findById(id);
        if (carrera.isEmpty()) {
            throw new BadRequestException(String.format("No exist any career with id %d", id));
        }
        carreraDAO.deleteById(carrera.get().getId());
    }

}
