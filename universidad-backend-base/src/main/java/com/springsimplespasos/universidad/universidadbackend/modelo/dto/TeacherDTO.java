package com.springsimplespasos.universidad.universidadbackend.modelo.dto;

import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Direccion;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class TeacherDTO extends PersonDTO {

    private BigDecimal salary;

    public TeacherDTO(Integer id, String name, String lastName, String dni, Direccion address,
        BigDecimal salary) {
        super(id, name, lastName, dni, address);
        this.salary = salary;
    }
}


