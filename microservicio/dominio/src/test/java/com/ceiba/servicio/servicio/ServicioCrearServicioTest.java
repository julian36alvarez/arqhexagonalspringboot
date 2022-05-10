package com.ceiba.servicio.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.mascota.modelo.entidad.Mascota;
import com.ceiba.mascota.puerto.repositorio.RepositorioMascota;
import com.ceiba.mascota.servicio.ServicioCrearMascota;
import com.ceiba.mascota.servicio.testdatabuilder.MascotaTestDataBuilder;
import com.ceiba.servicio.modelo.entidad.Servicio;
import com.ceiba.servicio.puerto.repositorio.RepositorioServicio;
import com.ceiba.servicio.servicio.testdatabuilder.ServicioTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


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

}