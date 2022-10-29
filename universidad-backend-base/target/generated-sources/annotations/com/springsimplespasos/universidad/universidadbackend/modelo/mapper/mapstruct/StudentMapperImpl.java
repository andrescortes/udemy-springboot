package com.springsimplespasos.universidad.universidadbackend.modelo.mapper.mapstruct;

import com.springsimplespasos.universidad.universidadbackend.modelo.dto.StudentDTO;
import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Alumno;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-08T16:18:55-0500",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.12 (Oracle Corporation)"
)
@Component
public class StudentMapperImpl extends StudentMapper {

    @Override
    public StudentDTO mapStudent(Alumno student) {
        if ( student == null ) {
            return null;
        }

        StudentDTO studentDTO = new StudentDTO();

        studentDTO.setId( student.getId() );
        studentDTO.setName( student.getNombre() );
        studentDTO.setLastName( student.getApellido() );
        studentDTO.setDni( student.getDni() );
        studentDTO.setAddress( student.getDireccion() );

        return studentDTO;
    }

    @Override
    public Alumno mapStudent(StudentDTO studentDTO) {
        if ( studentDTO == null ) {
            return null;
        }

        Alumno alumno = new Alumno();

        alumno.setId( studentDTO.getId() );
        alumno.setNombre( studentDTO.getName() );
        alumno.setApellido( studentDTO.getLastName() );
        alumno.setDni( studentDTO.getDni() );
        alumno.setDireccion( studentDTO.getAddress() );

        return alumno;
    }
}
