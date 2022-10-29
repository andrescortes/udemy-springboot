package com.springsimplespasos.universidad.universidadbackend.modelo.mapper.mapstruct;

import com.springsimplespasos.universidad.universidadbackend.modelo.dto.StudentDTO;
import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Alumno;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.MapperConfig;
import org.mapstruct.MappingTarget;

@MapperConfig
public interface StudentMapperConfig extends PersonMapperConfig {

    @InheritConfiguration(name = "mapPerson")
    void mapStudent(Alumno student, @MappingTarget StudentDTO studentDTO);

}
