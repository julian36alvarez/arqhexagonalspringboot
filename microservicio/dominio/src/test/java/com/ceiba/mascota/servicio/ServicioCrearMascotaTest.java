package com.ceiba.mascota.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.mascota.modelo.entidad.Mascota;
import com.ceiba.mascota.puerto.repositorio.RepositorioMascota;
import com.ceiba.mascota.servicio.testdatabuilder.MascotaTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class ServicioCrearMascotaTest {

    @Test
    @DisplayName("Deberia validar la existencia previa del cliente")
    void deberiaValidarLaExistenciaPreviaDelCliente() {
        // arrange
        Mascota mascota = new MascotaTestDataBuilder().conId(301L).build();
        RepositorioMascota repositorioMascota = Mockito.mock(RepositorioMascota.class);
        Mockito.when(repositorioMascota.existe(Mockito.anyLong())).thenReturn(false);
        ServicioCrearMascota servicioCrearMascota = new ServicioCrearMascota(repositorioMascota);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearMascota.ejecutar(mascota), ExcepcionValorInvalido.class,"El cliente no existe en el sistema");
    }

}