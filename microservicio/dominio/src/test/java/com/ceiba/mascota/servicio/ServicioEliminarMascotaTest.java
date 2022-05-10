package com.ceiba.mascota.servicio;

import com.ceiba.mascota.puerto.repositorio.RepositorioMascota;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.ServicioEliminarUsuario;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

 class ServicioEliminarMascotaTest {

    @Test
    @DisplayName("Deberia eliminar el usuario llamando al repositorio")
    void deberiaEliminarElUsuarioLlamandoAlRepositorio() {
        RepositorioMascota repositorioMascota = Mockito.mock(RepositorioMascota.class);
        ServicioEliminarMascota servicioEliminarMascota = new ServicioEliminarMascota(repositorioMascota);

        servicioEliminarMascota.ejecutar(1l);

        Mockito.verify(repositorioMascota, Mockito.times(1)).eliminar(1l);

    }

}
