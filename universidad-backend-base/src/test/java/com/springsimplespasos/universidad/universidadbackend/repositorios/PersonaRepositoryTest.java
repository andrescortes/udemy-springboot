package com.springsimplespasos.universidad.universidadbackend.repositorios;

import com.springsimplespasos.universidad.universidadbackend.datos.DatosDummy;
import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Empleado;
import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Persona;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class PersonaRepositoryTest {


    private final PersonaRepository studentRepository;

    private final PersonaRepository teacherRepository;

    private final PersonaRepository employeeRepository;


    PersonaRepositoryTest(
        @Qualifier("repositorioAlumnos") PersonaRepository studentRepository,
        @Qualifier("repositorioProfesores") PersonaRepository teacherRepository,
        @Qualifier("repositorioEmpleados") PersonaRepository employeeRepository
    ) {
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
        this.employeeRepository = employeeRepository;
    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    @DisplayName("Find an employee by name and last name")
    void buscarPorNombreYApellido() {
        //given
        Persona empleado = employeeRepository.save(DatosDummy.empleado01());
        System.out.println("persona = " + empleado);
        //when
        Optional<Persona> expected = employeeRepository.buscarPorNombreYApellido(
            DatosDummy.empleado01()
                .getNombre(), DatosDummy.empleado01().getApellido());

        //then
        Assertions.assertThat(expected.get()).isInstanceOf(Empleado.class);
        Assertions.assertThat(expected.get()).isEqualTo(empleado);
    }

    @Test
    @DisplayName("Find a teacher by dni")
    void buscarPorDni() {
        //given
        Persona save = teacherRepository.save(DatosDummy.profesor01());
        System.out.println("teacher save = " + save);

        //when
        Optional<Persona> expected = teacherRepository.buscarPorDni(
            DatosDummy.profesor01().getDni());
        System.out.println("expected = " + expected);

        //then
        Assertions.assertThat(expected.get()).isInstanceOf(Persona.class);
        Assertions.assertThat(expected.get()).isEqualTo(save);
        Assertions.assertThat(expected.get().getDni()).isEqualTo(save.getDni());
    }

    @Test
    void buscarPersonaPorApellido() {
        //given
        Iterable<Persona> students = studentRepository.saveAll(
            Arrays.asList(DatosDummy.alumno01(), DatosDummy.alumno02()));

        //when
        String lastName = DatosDummy.alumno01().getApellido();
        Iterable<Persona> expected = studentRepository.buscarPersonaPorApellido(
            lastName);

        //then
        Assertions.assertThat(((List<Persona>) expected).size() == 2).isTrue();
    }
}