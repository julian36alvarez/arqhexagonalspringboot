package com.ceiba.cliente.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.cliente.servicio.testdatabuilder.ClienteTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.cliente.modelo.entidad.Cliente;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.assertEquals;

 class ClienteTest {

    @Test
    @DisplayName("Deberia crear correctamente el Cliente")
    void deberiaCrearCorrectamenteElCliente() {

        //act
        Cliente cliente = new ClienteTestDataBuilder().conId(101l).build(); //.conFechaCreacion(fechaCreacion).conId(1L).build();
        //assert
        assertEquals(101, cliente.getId());
        assertEquals("Julian Alvarez", cliente.getNombre());
        assertEquals(1023898298, cliente.getIdentificacion());
        assertEquals("Dig 77 B # 116b -55", cliente.getDireccion());
        assertEquals(3013864954l, cliente.getTelefono());
    }

    @Test
    void deberiaFallarSinNombreDeUsuario() {

        //Arrange
        ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder().conNombre(null).conId(101l);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    clienteTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el nombre");
    }

    @Test
    void deberiaFallarSinIdentificacion() {

        //Arrange
        ClienteTestDataBuilder usuarioTestDataBuilder = new ClienteTestDataBuilder().conIdentificacion(null).conId(101l);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    usuarioTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar la identificacion");
    }


    @Test
    void deberiaFallarSinTelefono() {

        //Arrange
        ClienteTestDataBuilder usuarioTestDataBuilder = new ClienteTestDataBuilder().conTelefono(null).conId(101l);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    usuarioTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el telefono");
    }


}
