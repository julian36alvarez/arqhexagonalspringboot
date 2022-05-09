package com.ceiba.mascota.servicio.testdatabuilder;

import com.ceiba.mascota.modelo.entidad.Mascota;


public class MascotaTestDataBuilder {

    private Long id;
    private String  nombre;
    private String especie;
    private String raza;
    private Long idCliente;


    public MascotaTestDataBuilder() {
        nombre = "Olix";
        especie = "PERRO";
        raza = "Schnauzer";
        idCliente = 3l;
    }


    public MascotaTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public MascotaTestDataBuilder conEspecie(String especie) {
        this.especie = especie;
        return this;
    }

    public MascotaTestDataBuilder conRaza(String raza) {
        this.raza = raza;
        return this;
    }

    public MascotaTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public MascotaTestDataBuilder conIdCliente(Long idCliente) {
        this.idCliente = id;
        return this;
    }

    public Mascota build() {
        return new Mascota(id, nombre,especie,raza,idCliente);
    }
}
