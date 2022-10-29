package com.springsimplespasos.universidad.universidadbackend.servicios.implementaciones;


import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.anyString;

import com.springsimplespasos.universidad.universidadbackend.repositorios.AlumnoRepository;
import com.springsimplespasos.universidad.universidadbackend.servicios.contratos.AlumnoDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class AlumnoDAOImplTest {

    @MockBean
    AlumnoRepository alumnoRepository;

    @Autowired
    AlumnoDAO alumnoDAO;

    @BeforeEach
    void setUp() {
    }

    @Test
    void buscarAlumnosPorNombreCarrera() {
        //when
        alumnoDAO.buscarAlumnosPorNombreCarrera(anyString());

        //then
        verify(alumnoRepository).buscarAlumnosPorNombreCarrera(anyString());
    }
}