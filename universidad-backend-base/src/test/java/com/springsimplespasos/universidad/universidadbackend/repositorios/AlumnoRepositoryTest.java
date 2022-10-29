package com.springsimplespasos.universidad.universidadbackend.repositorios;

import com.springsimplespasos.universidad.universidadbackend.datos.DatosDummy;
import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Alumno;
import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Carrera;
import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Persona;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class AlumnoRepositoryTest {

    private final PersonaRepository studentRepository;

    private final CarreraRepository carreraRepository;

    @Autowired
    AlumnoRepositoryTest(
        @Qualifier("repositorioAlumnos") PersonaRepository studentRepository,
        CarreraRepository carreraRepository) {
        this.studentRepository = studentRepository;
        this.carreraRepository = carreraRepository;
    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void buscarAlumnosPorNombreCarrera() {
        //given
        Iterable<Persona> personas = studentRepository.saveAll(
            Arrays.asList(
                DatosDummy.alumno01(),
                DatosDummy.alumno02(),
                DatosDummy.alumno03()
            ));

        Carrera save = carreraRepository.save(DatosDummy.carrera02());

        personas.forEach(student -> ((Alumno) student).setCarrera(save));

        studentRepository.saveAll(personas);

        //when
        String nombreCarrera = "Licenciatura en Sistemas";
        List<Persona> expected = (List<Persona>) ((AlumnoRepository) studentRepository).buscarAlumnosPorNombreCarrera(
            nombreCarrera);

        //then
        Assertions.assertThat(expected.size() == 3).isTrue();
    }
    @Test
    void buscarAlumnosPorNombreCarreraSinValores() {
        //given
        Iterable<Persona> personas = studentRepository.saveAll(
            Arrays.asList(
                DatosDummy.alumno01(),
                DatosDummy.alumno02(),
                DatosDummy.alumno03()
            ));

        Carrera save = carreraRepository.save(DatosDummy.carrera02());

        personas.forEach(student -> ((Alumno) student).setCarrera(save));

        studentRepository.saveAll(personas);

        //when
        String nombreCarrera = "Licenciatura en Alimentos";
        List<Persona> expected = (List<Persona>) ((AlumnoRepository) studentRepository).buscarAlumnosPorNombreCarrera(
            nombreCarrera);

        //then
        Assertions.assertThat(expected.isEmpty()).isTrue();
    }
}