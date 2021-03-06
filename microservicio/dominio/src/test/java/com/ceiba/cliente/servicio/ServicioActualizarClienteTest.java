package com.ceiba.cliente.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.cliente.servicio.testdatabuilder.ClienteTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

 class ServicioActualizarClienteTest {

    @Test
    @DisplayName("Deberia validar la existencia previa del cliente")
    void deberiaValidarLaExistenciaPreviaDelCliente() {
        // arrange
        Cliente cliente = new ClienteTestDataBuilder().conId(101L).build();
        RepositorioCliente repositorioCliente = Mockito.mock(RepositorioCliente.class);
        Mockito.when(repositorioCliente.existePorId(500l)).thenReturn(false);
        ServicioActualizarCliente servicioActualizarCliente = new ServicioActualizarCliente(repositorioCliente);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarCliente.ejecutar(cliente), ExcepcionDuplicidad.class,"El cliente no existe en el sistema");
    }

    @Test
    @DisplayName("Deberia actualizar correctamente en el cliente en el repositorio")
    void deberiaActualizarCorrectamenteEnElRepositorio() {
        // arrange
        Cliente cliente = new ClienteTestDataBuilder().conId(101L).build();
        RepositorioCliente repositorioCliente = Mockito.mock(RepositorioCliente.class);
        Mockito.when(repositorioCliente.existePorId(Mockito.anyLong())).thenReturn(true);
        ServicioActualizarCliente servicioActualizarCliente = new ServicioActualizarCliente(repositorioCliente);
        // act
        servicioActualizarCliente.ejecutar(cliente);
        //assert
        Mockito.verify(repositorioCliente,Mockito.times(1)).actualizar(cliente);
    }
}
