package com.ceiba.cliente.servicio;

import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

 class ServicioEliminarClienteTest {

    @Test
    @DisplayName("Deberia eliminar el Cliente llamando al repositorio")
    void deberiaEliminarElClienteLlamandoAlRepositorio() {
        RepositorioCliente repositorioCliente = Mockito.mock(RepositorioCliente.class);
        ServicioEliminarCliente servicioEliminarCliente = new ServicioEliminarCliente(repositorioCliente);

        servicioEliminarCliente.ejecutar(1l);

        Mockito.verify(repositorioCliente, Mockito.times(1)).eliminar(1l);

    }

}
