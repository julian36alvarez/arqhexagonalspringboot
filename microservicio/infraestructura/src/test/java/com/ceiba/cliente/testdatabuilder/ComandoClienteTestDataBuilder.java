package com.ceiba.cliente.testdatabuilder;

import com.ceiba.cliente.comando.ComandoCliente;
import com.ceiba.usuario.comando.ComandoUsuario;



public class ComandoClienteTestDataBuilder {

    private Long id;
    private Long identificacion;
    private String nombre;
    private String direccion;
    private Long telefono;

    public ComandoClienteTestDataBuilder() {
        identificacion = 1023898298l;
        nombre ="Julian Alvarez";
        direccion ="Dig 77 B # 116b -55";
        telefono =3013864954l;
    }

    public ComandoClienteTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ComandoCliente build() {
        return new ComandoCliente(id,identificacion, nombre,direccion, telefono);
    }
}
