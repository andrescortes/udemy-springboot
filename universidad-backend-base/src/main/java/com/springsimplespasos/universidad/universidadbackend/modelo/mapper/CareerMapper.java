package com.springsimplespasos.universidad.universidadbackend.modelo.mapper;

import com.springsimplespasos.universidad.universidadbackend.modelo.dto.CareerDTO;
import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Carrera;
@Deprecated
public class CareerMapper {
    public static CareerDTO mapCareer(Carrera career) {
        CareerDTO careerDTO = new CareerDTO();
        careerDTO.setId(career.getId());
        careerDTO.setName(career.getNombre());
        careerDTO.setAmountYears(career.getCantidadAnios());
        careerDTO.setAmountSubjects(career.getCantidaMaterias());

        return careerDTO;
    }
}
