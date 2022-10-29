package com.springsimplespasos.universidad.universidadbackend.modelo.dto;

import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Direccion;
import lombok.NoArgsConstructor;



@NoArgsConstructor
public class StudentDTO extends PersonDTO {

    public StudentDTO(Integer id, String name, String lastName, String dni, Direccion address) {
        super(id, name, lastName, dni, address);
    }

}
