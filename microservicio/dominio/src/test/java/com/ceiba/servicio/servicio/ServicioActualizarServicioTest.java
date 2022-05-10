package com.ceiba.servicio.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.servicio.modelo.entidad.Servicio;
import com.ceiba.servicio.puerto.repositorio.RepositorioServicio;
import com.ceiba.servicio.servicio.testdatabuilder.ServicioTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

 class ServicioActualizarServicioTest {

    @Test
    @DisplayName("Deberia validar la existencia previa del servicio")
    void deberiaValidarLaExistenciaPreviaDelUsuario() {
        // arrange
        Servicio servicio = new ServicioTestDataBuilder().conId(1L).build();
        RepositorioServicio repositorioServicio = Mockito.mock(RepositorioServicio.class);
        Mockito.when(repositorioServicio.existePorId(Mockito.anyLong())).thenReturn(false);
        ServicioActualizarServicio servicioActualizarServicio = new ServicioActualizarServicio(repositorioServicio);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarServicio.ejecutar(servicio), ExcepcionDuplicidad.class,"El servicio no existe en el sistema");
    }

    @Test
    @DisplayName("Deberia actualizar correctamente en el repositorio")
    void deberiaActualizarCorrectamenteEnElRepositorio() {
        // arrange
        Servicio servicio = new ServicioTestDataBuilder().conId(1L).build();
        RepositorioServicio repositorioServicio = Mockito.mock(RepositorioServicio.class);
        Mockito.when(repositorioServicio.existePorId(Mockito.anyLong())).thenReturn(true);
        ServicioActualizarServicio servicioActualizarServicio = new ServicioActualizarServicio(repositorioServicio);
        // act
        servicioActualizarServicio.ejecutar(servicio);
        //assert
        Mockito.verify(repositorioServicio,Mockito.times(1)).actualizar(servicio);
    }
}
