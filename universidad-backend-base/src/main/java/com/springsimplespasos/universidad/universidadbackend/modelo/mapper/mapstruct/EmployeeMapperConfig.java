package com.springsimplespasos.universidad.universidadbackend.modelo.mapper.mapstruct;

import com.springsimplespasos.universidad.universidadbackend.modelo.dto.EmployeeDTO;
import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Empleado;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.MapperConfig;
import org.mapstruct.MappingTarget;

@MapperConfig
public interface EmployeeMapperConfig extends PersonMapperConfig {

    @InheritConfiguration(name = "mapPerson")
    void mapEmployee(Empleado employee, @MappingTarget EmployeeDTO employeeDTO);


}
