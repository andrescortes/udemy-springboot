package com.springsimplespasos.universidad.universidadbackend.servicios.implementaciones;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.springsimplespasos.universidad.universidadbackend.datos.DatosDummy;
import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Carrera;
import com.springsimplespasos.universidad.universidadbackend.repositorios.CarreraRepository;
import com.springsimplespasos.universidad.universidadbackend.servicios.contratos.CarreraDAO;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarreraDAOImplTest {

    private CarreraDAO carreraDAO;

    private CarreraRepository carreraRepository;


    @BeforeEach
    void setUp() {
        carreraRepository = mock(CarreraRepository.class);
        carreraDAO = new CarreraDAOImpl(carreraRepository);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findCarrerasByNombreContains() {
        //given
        String careerName = "Ingenieria";

        when(carreraRepository.findCarrerasByNombreContains(careerName))
            .thenReturn(
                Arrays.asList(
                    DatosDummy.carrera01(true),
                    DatosDummy.carrera03(true)
                ));

        //when
        List<Carrera> expected = (List<Carrera>) carreraDAO.findCarrerasByNombreContains(
            careerName);

        //then
        Assertions.assertThat(expected.get(0)).isEqualTo(DatosDummy.carrera01(true));
        Assertions.assertThat(expected.get(1)).isEqualTo(DatosDummy.carrera03(true));

        verify(carreraRepository).findCarrerasByNombreContains(
            careerName);//verify if the method was called really
    }

    @Test
    void findCarrerasByNombreContainsIgnoreCase() {
        //given
        String careerName = "ingenieria";

        when(carreraRepository.findCarrerasByNombreContainsIgnoreCase(careerName))
            .thenReturn(
                Arrays.asList(
                    DatosDummy.carrera01(true),
                    DatosDummy.carrera03(true)
                ));

        //when
        List<Carrera> expected = (List<Carrera>) carreraDAO.findCarrerasByNombreContainsIgnoreCase(
            careerName);

        //then
        Assertions.assertThat(expected.get(0)).isEqualTo(DatosDummy.carrera01(true));
        Assertions.assertThat(expected.get(1)).isEqualTo(DatosDummy.carrera03(true));

        verify(carreraRepository).findCarrerasByNombreContainsIgnoreCase(
            careerName);//verify if the method was called really
    }

    @Test
    void findCarrerasByCantidadAniosAfter() {
        //given
        int amountYears = 4;

        when(carreraRepository.findCarrerasByCantidadAniosAfter(amountYears))
            .thenReturn(
                Arrays.asList(
                    DatosDummy.carrera01(true),
                    DatosDummy.carrera03(true)
                ));

        //when
        List<Carrera> expected = (List<Carrera>) carreraDAO.findCarrerasByCantidadAniosAfter(
            amountYears);

        //then
        Assertions.assertThat(expected.get(0)).isEqualTo(DatosDummy.carrera01(true));
        Assertions.assertThat(expected.get(1)).isEqualTo(DatosDummy.carrera03(true));

        verify(carreraRepository).findCarrerasByCantidadAniosAfter(
            amountYears);//verify if the method was called really
    }
}