package com.springsimplespasos.universidad.universidadbackend.modelo.mapper.mapstruct;

import com.springsimplespasos.universidad.universidadbackend.modelo.dto.PersonDTO;
import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Persona;
import org.mapstruct.MapperConfig;
import org.mapstruct.MappingTarget;

@MapperConfig//(componentModel = "spring")
public interface PersonMapperConfig {

    void mapPerson(Persona person, @MappingTarget PersonDTO personDTO);

}
