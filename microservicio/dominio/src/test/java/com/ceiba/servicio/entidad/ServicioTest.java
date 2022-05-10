package com.ceiba.servicio.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.servicio.servicio.testdatabuilder.ServicioTestDataBuilder;
import com.ceiba.servicio.modelo.entidad.Servicio;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

import static org.junit.jupiter.api.Assertions.assertEquals;

 class ServicioTest {

    @Test
    @DisplayName("Deberia crear correctamente el servicio")
    void deberiaCrearCorrectamenteElServicio() {
        // arrange

        LocalDateTime dateTime = LocalDate.now().atTime(10, 0);
        LocalDateTime fechaServicio = dateTime.with(TemporalAdjusters.next(DayOfWeek.MONDAY));

        //act
        Servicio servicio = new ServicioTestDataBuilder().conFechaProgramada(fechaServicio).conId(1L).build();
        //assert
        assertEquals(1, servicio.getId());
        assertEquals(1, servicio.getIdUsuario());
        assertEquals(1, servicio.getTipoUsuario());
        assertEquals(1, servicio.getTipoServicio());

    }

    @Test
    void deberiaFallarSinIdCliente() {

        //Arrange
        ServicioTestDataBuilder servicioTestDataBuilder = new ServicioTestDataBuilder().conIdUsuario(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    servicioTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar id usuario");
    }



    @Test
    void deberiaFallarSinTipoCliente() {

        //Arrange
        ServicioTestDataBuilder servicioTestDataBuilder = new ServicioTestDataBuilder().conTipoUsuario(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    servicioTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar tipo usuario");
    }



    @Test
    void deberiaFallarSinTipoServicio() {

        //Arrange
        ServicioTestDataBuilder servicioTestDataBuilder = new ServicioTestDataBuilder().conTipoServicio(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    servicioTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el tipo servicio");
    }

    @Test
    void deberiaFallarSinIdMascota() {

        //Arrange
        ServicioTestDataBuilder servicioTestDataBuilder = new ServicioTestDataBuilder().conIdMascota(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    servicioTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe id de la mascota");
    }

    @Test
    void deberiaFallarSinFechaProgramada() {

        //Arrange
        ServicioTestDataBuilder servicioTestDataBuilder = new ServicioTestDataBuilder().conFechaProgramada(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    servicioTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar la fecha Programada");
    }

    @Test
    void deberiaFallarSiEsUnSabado() {

        LocalDateTime dateTime = LocalDateTime.now();
        LocalDateTime nextSaturday = dateTime.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
        //Arrange
        ServicioTestDataBuilder servicioTestDataBuilder = new ServicioTestDataBuilder().conFechaProgramada(nextSaturday).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    servicioTestDataBuilder.build();
                },
                ExcepcionValorInvalido.class, "Se debe programar la cita en un dia habil L-V");
    }

    @Test
    void deberiaFallarSiEsUnDomingo() {

        LocalDateTime dateTime = LocalDateTime.now();
        LocalDateTime nextSunday = dateTime.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
        //Arrange
        ServicioTestDataBuilder servicioTestDataBuilder = new ServicioTestDataBuilder().conFechaProgramada(nextSunday).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    servicioTestDataBuilder.build();
                },
                ExcepcionValorInvalido.class, "Se debe programar la cita en un dia habil L-V");
    }

    @Test
    void deberiaFallarSiLaFechaEsPasada() {

        LocalDateTime dateTime = LocalDate.now().atTime(13, 0);
        LocalDateTime previousSunday = dateTime.with(TemporalAdjusters.previous(DayOfWeek.MONDAY));
        //Arrange
        ServicioTestDataBuilder servicioTestDataBuilder = new ServicioTestDataBuilder().conFechaProgramada(previousSunday).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    servicioTestDataBuilder.build();
                },
                ExcepcionValorInvalido.class, "Fecha no valida");
    }

    @Test
    void deberiaFallarSiLaHoraEsMayorALasCuatro() {
        LocalDateTime dateTime = LocalDate.now().atTime(16, 0);
        LocalDateTime dateTimeHora = dateTime.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        //Arrange
        ServicioTestDataBuilder servicioTestDataBuilder = new ServicioTestDataBuilder().conFechaProgramada(dateTimeHora).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    servicioTestDataBuilder.build();
                },
                ExcepcionValorInvalido.class, "Hora no valida");
    }

    @Test
    void deberiaFallarSiElTipoServicioNoExiste(){

        ServicioTestDataBuilder servicioTestDataBuilder = new ServicioTestDataBuilder().conTipoServicio(5l).conId(1L);

        BasePrueba.assertThrows(() -> {
                    servicioTestDataBuilder.build();
                },
                ExcepcionValorInvalido.class, "Se debe ingresar el tipo servicio correcto");
    }

    @Test
    void deberiaFallarSiElTipoClienteNoExiste(){

        ServicioTestDataBuilder servicioTestDataBuilder = new ServicioTestDataBuilder().conTipoUsuario(5l).conId(1L);

        BasePrueba.assertThrows(() -> {
                    servicioTestDataBuilder.build();
                },
                ExcepcionValorInvalido.class, "Se debe ingresar tipo usuario correcto");
    }


}
