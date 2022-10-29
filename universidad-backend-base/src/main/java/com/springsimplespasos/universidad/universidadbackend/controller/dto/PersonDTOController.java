package com.springsimplespasos.universidad.universidadbackend.controller.dto;

import com.springsimplespasos.universidad.universidadbackend.modelo.dto.PersonDTO;
import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Alumno;
import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Empleado;
import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Persona;
import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Profesor;
import com.springsimplespasos.universidad.universidadbackend.modelo.mapper.mapstruct.StudentMapper;
import com.springsimplespasos.universidad.universidadbackend.servicios.contratos.PersonaDAO;

public class PersonDTOController extends GenericDTOController<Persona, PersonaDAO> {

    protected final StudentMapper studentMapper;

    public PersonDTOController(PersonaDAO service, String nameEntity, StudentMapper studentMapper) {
        super(service, nameEntity);
        this.studentMapper = studentMapper;
    }

    public PersonDTO createPerson(Persona person){
        Persona personEntity = super.createEntity(person);
        PersonDTO entityDTO = null;
        if(personEntity instanceof Alumno){
            entityDTO = studentMapper.mapStudent((Alumno) personEntity);
        } else if(personEntity instanceof Profesor){
            //we have to apply the mapper for the professor
        }else if(personEntity instanceof Empleado){
            //we have to apply the mapper for the employee
        }
        return entityDTO;
    }
}
