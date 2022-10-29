package com.springsimplespasos.universidad.universidadbackend.controller.dto;

import com.springsimplespasos.universidad.universidadbackend.modelo.dto.CareerDTO;
import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Carrera;
import com.springsimplespasos.universidad.universidadbackend.modelo.mapper.mapstruct.CarreraMapperMapStruct;
import com.springsimplespasos.universidad.universidadbackend.servicios.contratos.CarreraDAO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/careers")
@ConditionalOnProperty(prefix = "app", name = "controller.enable-dto", havingValue = "true")
@Api(value = "Career DTO Controller", tags = "Operations pertaining to Career DTO")
public class CareerDTOController extends GenericDTOController<Carrera, CarreraDAO> {

    private final CarreraMapperMapStruct carreraMapperMapStruct;

    public CareerDTOController(CarreraDAO service, CarreraMapperMapStruct carreraMapperMapStruct) {
        super(service, "career");
        this.carreraMapperMapStruct = carreraMapperMapStruct;
    }

    @GetMapping("/all")
    @ApiOperation(value = "Get all careers", response = CareerDTO.class, responseContainer = "List")
    @ApiResponses({
        @ApiResponse(code = 200, message = "Successfully retrieved list"),
        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<?> getAllCareers() {
        Map<String, Object> message = new HashMap<>();
        List<Carrera> careers = super.getAllEntities();
        if (careers.isEmpty()) {
            message.put("message", String.format("No there are any %s", nameEntity));
            message.put("Success", Boolean.FALSE);
            return ResponseEntity.badRequest().body(message);
        }
        List<CareerDTO> careerDTOs = careers.stream()
            //.map(CareerMapper::mapCareer)
            //.map(carrera -> CareerMapper.mapCareer(carrera))
            //.map(career -> carreraMapperMapStruct.mapCareer(career))
            .map(carreraMapperMapStruct::mapCareer)
            .collect(java.util.stream.Collectors.toList());

        message.put("data", careerDTOs);
        message.put("Success", Boolean.TRUE);
        return ResponseEntity.ok(message);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get career by id", response = CareerDTO.class, responseContainer = "Entity")
    @ApiResponses({
        @ApiResponse(code = 200, message = "Successfully retrieved career"),
        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<?> getCareerById(@PathVariable(value = "id") Integer id) {
        Optional<CareerDTO> careerDTO = service.findById(id).map(carreraMapperMapStruct::mapCareer);
        Map<String, Object> message = new HashMap<>();
        if (careerDTO.isEmpty()) {
            message.put("message", String.format("No there is any %s with id %s", nameEntity, id));
            message.put("Success", Boolean.FALSE);
            return ResponseEntity.badRequest().body(message);
        }
        message.put("data", careerDTO);
        message.put("Success", Boolean.TRUE);
        return ResponseEntity.ok(message);
    }

    @PostMapping("/create")
    @ApiOperation(value = "Create career", response = CareerDTO.class, responseContainer = "Entity")
    @ApiResponses({
        @ApiResponse(code = 200, message = "Successfully created career"),
        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<?> createCareer(
        @RequestBody @ApiParam(name = "Request body type CareerDTO") CareerDTO careerDTO
    ) {
        /*Map<String, Object> message = new HashMap<>();
        Carrera career = carreraMapperMapStruct.mapCareer(careerDTO);
        career = service.save(career);
        if (career == null) {
            message.put("message", String.format("No there is any %s with id %s", nameEntity, career.getId()));
            message.put("Success", Boolean.FALSE);
            return ResponseEntity.badRequest().body(message);
        }
        message.put("data", career);
        message.put("Success", Boolean.TRUE);*/
        return ResponseEntity.ok("message");
    }

}
