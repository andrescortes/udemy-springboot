package com.springsimplespasos.universidad.universidadbackend.servicios.implementaciones;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.verify;

import com.springsimplespasos.universidad.universidadbackend.repositorios.AlumnoRepository;
import com.springsimplespasos.universidad.universidadbackend.servicios.contratos.PersonaDAO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PersonaDAOImplTest {

    PersonaDAO personaDAO;
    @Mock
    AlumnoRepository alumnoRepository;

    @BeforeEach
    void setUp() {
        personaDAO = new PersonaDAOImpl(alumnoRepository);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void buscarPorNombreYApellido() {
        //when
        personaDAO.buscarPorNombreYApellido(anyString(), anyString());

        //then
        verify(alumnoRepository).buscarPorNombreYApellido(anyString(), anyString());
    }

    @Test
    void buscarPorDni() {
        //when
        personaDAO.buscarPorDni(anyString());

        //then
        verify(alumnoRepository).buscarPorDni(anyString());
    }

    @Test
    void buscarPersonaPorApellido() {
        //when
        personaDAO.buscarPersonaPorApellido(anyString());

        //then
        verify(alumnoRepository).buscarPersonaPorApellido(anyString());
    }
}