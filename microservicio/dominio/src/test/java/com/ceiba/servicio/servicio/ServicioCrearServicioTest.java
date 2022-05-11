package com.ceiba.servicio.servicio;

import com.ceiba.BasePrueba;

import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;

import com.ceiba.servicio.modelo.entidad.Servicio;
import com.ceiba.servicio.puerto.repositorio.RepositorioServicio;
import com.ceiba.servicio.servicio.testdatabuilder.ServicioTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

import static org.junit.jupiter.api.Assertions.assertEquals;


class ServicioCrearServicioTest {

    @Test
    @DisplayName("Deberia validar la existencia previa del cliente")
    void deberiaValidarLaExistenciaPreviaDelCliente() {
        // arrange
        Servicio servicio = new ServicioTestDataBuilder().conId(1L).build();
        RepositorioServicio repositorioServicio = Mockito.mock(RepositorioServicio.class);
        Mockito.when(repositorioServicio.existePorIdCliente(Mockito.anyLong())).thenReturn(false);
        ServicioCrearServicio servicioCrearServicio = new ServicioCrearServicio(repositorioServicio);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearServicio.ejecutar(servicio), ExcepcionValorInvalido.class,"El cliente no existe, ingresar como cliente generico id = 2");
    }

    @Test
    @DisplayName("Deberia crear correctamente en el repositorio")
    void deberiaCrearCorrectamenteElServicioParaUnClienteInvitado() {
        // arrange
        LocalDateTime dateTime = LocalDate.now().atTime(10, 0);
        LocalDateTime fechaServicio = dateTime.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        Servicio servicio = new ServicioTestDataBuilder().conFechaProgramada(fechaServicio).conId(1L).conTipoUsuario(2l).build();
        RepositorioServicio repositorioServicio = Mockito.mock(RepositorioServicio.class);
        ServicioCrearServicio servicioCrearServicio = new ServicioCrearServicio(repositorioServicio);
        // act
        servicioCrearServicio.ejecutar(servicio);
        //assert
        assertEquals(fechaServicio.plusHours(2), servicio.getFechaEntrega());
        assertEquals(fechaServicio, servicio.getFechaContable());
        assertEquals(50000d,servicio.getTotal());
        Mockito.verify(repositorioServicio,Mockito.times(1)).crear(servicio);
    }

    @Test
    @DisplayName("Deberia crear correctamente en el repositorio")
    void deberiaCrearCorrectamenteEnElRepositorioClienteCuandoEsFEstivo() {
        // arrange
        LocalDate fechaFestivo = LocalDate.of(2022,5,30);
        LocalDateTime fechaServicio = fechaFestivo.atStartOfDay();
        Servicio servicio = new ServicioTestDataBuilder().conFechaProgramada(fechaServicio).conId(1L).conTipoUsuario(2L).build();
        RepositorioServicio repositorioServicio = Mockito.mock(RepositorioServicio.class);
        ServicioCrearServicio servicioCrearServicio = new ServicioCrearServicio(repositorioServicio);
        servicioCrearServicio.ejecutar(servicio);
        assertEquals(fechaServicio.plusHours(2), servicio.getFechaEntrega());
        assertEquals(fechaServicio, servicio.getFechaContable());
        assertEquals(100000d,servicio.getTotal());

    }

}