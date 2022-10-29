package com.springsimplespasos.universidad.universidadbackend.modelo.mapper.mapstruct;

import com.springsimplespasos.universidad.universidadbackend.modelo.dto.CareerDTO;
import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Carrera;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CarreraMapperMapStruct {
    @Mappings({
        @Mapping(source = "id", target = "id"),
        @Mapping(source = "nombre", target = "name"),
        @Mapping(source = "cantidadAnios", target = "amountYears"),
        @Mapping(source = "cantidaMaterias", target = "amountSubjects")
    })
    CareerDTO mapCareer(Carrera carrera);
}
