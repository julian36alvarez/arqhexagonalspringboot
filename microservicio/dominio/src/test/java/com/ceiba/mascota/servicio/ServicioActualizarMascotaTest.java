package com.ceiba.mascota.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.mascota.modelo.entidad.Mascota;
import com.ceiba.mascota.puerto.repositorio.RepositorioMascota;
import com.ceiba.mascota.servicio.testdatabuilder.MascotaTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioActualizarMascotaTest {

    @Test
    @DisplayName("Deberia validar la existencia previa del usuario")
    void deberiaValidarLaExistenciaPreviaDelUsuario() {
        // arrange
        Mascota mascota = new MascotaTestDataBuilder().conId(301L).build();
        RepositorioMascota repositorioMascota = Mockito.mock(RepositorioMascota.class);
        Mockito.when(repositorioMascota.existePorId(Mockito.anyLong())).thenReturn(false);
        ServicioActualizarMascota servicioActualizarMascota = new ServicioActualizarMascota(repositorioMascota);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarMascota.ejecutar(mascota), ExcepcionDuplicidad.class,"La mascota no existe en el sistema");
    }

    @Test
    @DisplayName("Deberia actualizar correctamente en el repositorio")
    void deberiaActualizarCorrectamenteEnElRepositorio() {
        // arrange
        Mascota mascota = new MascotaTestDataBuilder().conId(301L).build();
        RepositorioMascota repositorioMascota = Mockito.mock(RepositorioMascota.class);
        Mockito.when(repositorioMascota.existePorId(Mockito.anyLong())).thenReturn(true);
        ServicioActualizarMascota servicioActualizarMascota = new ServicioActualizarMascota(repositorioMascota);
        // act
        servicioActualizarMascota.ejecutar(mascota);
        //assert
        Mockito.verify(repositorioMascota,Mockito.times(1)).actualizar(mascota);
    }
}
