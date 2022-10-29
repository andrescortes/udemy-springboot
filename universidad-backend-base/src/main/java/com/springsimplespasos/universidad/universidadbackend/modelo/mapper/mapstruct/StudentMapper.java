package com.springsimplespasos.universidad.universidadbackend.modelo.mapper.mapstruct;

import com.springsimplespasos.universidad.universidadbackend.modelo.dto.StudentDTO;
import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Alumno;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", config = StudentMapperConfig.class)
public abstract class StudentMapper {

    @Mappings({
        @Mapping(source = "id", target = "id"),
        @Mapping(source = "nombre", target = "name"),
        @Mapping(source = "apellido", target = "lastName"),
        @Mapping(source = "dni", target = "dni"),
        @Mapping(source = "direccion", target = "address")
    })
    public abstract StudentDTO mapStudent(Alumno student);

    @Mappings({
        @Mapping(source = "id", target = "id"),
        @Mapping(source = "name", target = "nombre"),
        @Mapping(source = "lastName", target = "apellido"),
        @Mapping(source = "dni", target = "dni"),
        @Mapping(source = "address", target = "direccion")
    })
    public abstract Alumno mapStudent(StudentDTO studentDTO);
}
