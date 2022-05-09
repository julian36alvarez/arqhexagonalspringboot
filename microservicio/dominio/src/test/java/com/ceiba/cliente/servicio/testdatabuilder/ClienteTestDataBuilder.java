package com.ceiba.cliente.servicio.testdatabuilder;

import com.ceiba.cliente.modelo.entidad.Cliente;


public class ClienteTestDataBuilder {

    private Long id;
    private Long identificacion;
    private String nombre;
    private String direccion;
    private Long telefono;

    public ClienteTestDataBuilder() {
        identificacion = 1023898298l;
        nombre ="Julian Alvarez";
        direccion ="Dig 77 B # 116b -55";
        telefono =3013864954l;
    }

    public ClienteTestDataBuilder conIdentificacion(Long identificacion) {
        this.identificacion = identificacion;
        return this;
    }

    public ClienteTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ClienteTestDataBuilder conDireccion(String direccion) {
        this.direccion = direccion;
        return this;
    }

    public ClienteTestDataBuilder conTelefono(Long telefono) {
        this.telefono = telefono;
        return this;
    }

    public ClienteTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public Cliente build() {
        return new Cliente(id,identificacion, nombre,direccion, telefono);
    }
}
