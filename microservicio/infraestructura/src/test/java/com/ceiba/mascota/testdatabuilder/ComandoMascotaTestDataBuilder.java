package com.ceiba.mascota.testdatabuilder;

import com.ceiba.mascota.comando.ComandoMascota;


public class ComandoMascotaTestDataBuilder {

    private Long id;
    private String  nombre;
    private String especie;
    private String raza;
    private Long idCliente;

    public ComandoMascotaTestDataBuilder() {
        nombre = "Olix";
        especie = "PERRO";
        raza = "Schnauzer";
        idCliente = 3l;
    }

    public ComandoMascotaTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ComandoMascota build() {
        return new ComandoMascota(id, nombre,especie,raza,idCliente);
    }
}
