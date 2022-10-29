package com.springsimplespasos.universidad.universidadbackend.modelo.dto;

import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Direccion;
import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.enumeradores.TipoEmpleado;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class EmployeeDTO extends PersonDTO {

    private BigDecimal salary;
    private TipoEmpleado typeEmployee;

    public EmployeeDTO(Integer id, String name, String lastName, String dni, Direccion address,
        BigDecimal salary, TipoEmpleado typeEmployee) {
        super(id, name, lastName, dni, address);
        this.salary = salary;
        this.typeEmployee = typeEmployee;
    }
}
