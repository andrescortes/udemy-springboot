package com.springsimplespasos.universidad.universidadbackend.modelo.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Alumno;
import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Direccion;
import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Profesor;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "type"
)//annotation to tell Jackson to use the 'type' property to determine the type of the object
@JsonSubTypes(
    {
        @JsonSubTypes.Type(value = StudentDTO.class, name = "alumno"),
        @JsonSubTypes.Type(value = TeacherDTO.class, name = "profesor")
    }
)
public abstract class PersonDTO {

    private Integer id;
    private String name;
    private String lastName;
    @Pattern(regexp = "^[0-9]+", message = "DNI must be numeric")
    @Size(min = 1, max = 10)
    private String dni;
    private Direccion address;

}
