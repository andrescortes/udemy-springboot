package com.springsimplespasos.universidad.universidadbackend.modelo.mapper.mapstruct;

import com.springsimplespasos.universidad.universidadbackend.modelo.dto.TeacherDTO;
import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Profesor;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.MapperConfig;
import org.mapstruct.MappingTarget;

@MapperConfig
public interface TeacherMapperConfig extends PersonMapperConfig {

    @InheritConfiguration(name = "mapPerson")
    void mapTeacher(Profesor teacher, @MappingTarget TeacherDTO teacherDTO);
}


