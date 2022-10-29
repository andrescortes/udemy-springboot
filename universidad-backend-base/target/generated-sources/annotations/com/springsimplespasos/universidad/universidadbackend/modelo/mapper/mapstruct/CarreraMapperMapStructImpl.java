package com.springsimplespasos.universidad.universidadbackend.modelo.mapper.mapstruct;

import com.springsimplespasos.universidad.universidadbackend.modelo.dto.CareerDTO;
import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Carrera;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-08T16:18:55-0500",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.12 (Oracle Corporation)"
)
@Component
public class CarreraMapperMapStructImpl implements CarreraMapperMapStruct {

    @Override
    public CareerDTO mapCareer(Carrera carrera) {
        if ( carrera == null ) {
            return null;
        }

        CareerDTO careerDTO = new CareerDTO();

        careerDTO.setId( carrera.getId() );
        careerDTO.setName( carrera.getNombre() );
        careerDTO.setAmountYears( carrera.getCantidadAnios() );
        careerDTO.setAmountSubjects( carrera.getCantidaMaterias() );

        return careerDTO;
    }
}
