package com.ceiba.servicio.servicio;

import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.ServicioEliminarUsuario;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioEliminarUsuarioTest {

    @Test
    @DisplayName("Deberia eliminar el usuario llamando al repositorio")
    void deberiaEliminarElUsuarioLlamandoAlRepositorio() {
        RepositorioUsuario repositorioUsuario = Mockito.mock(RepositorioUsuario.class);
        ServicioEliminarUsuario servicioEliminarUsuario = new ServicioEliminarUsuario(repositorioUsuario);

        servicioEliminarUsuario.ejecutar(1l);

        Mockito.verify(repositorioUsuario, Mockito.times(1)).eliminar(1l);

    }

}
