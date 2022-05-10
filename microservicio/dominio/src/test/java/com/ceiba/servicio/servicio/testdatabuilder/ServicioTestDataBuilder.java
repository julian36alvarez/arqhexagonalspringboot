package com.ceiba.servicio.servicio.testdatabuilder;

import com.ceiba.servicio.modelo.entidad.Servicio;


import java.time.LocalDateTime;

public class ServicioTestDataBuilder {

    private Long id;
    private Long idUsuario;
    private Long tipoUsuario;
    private Long tipoServicio;
    private Long idMascota;

    private LocalDateTime fechaProgramada;

    public ServicioTestDataBuilder() {
        idUsuario = 1l;
        tipoUsuario = 1l;
        tipoServicio = 1l;
        idMascota = 1l;
        fechaProgramada = LocalDateTime.now().plusDays(1).minusHours(5);;
    }

    public ServicioTestDataBuilder conIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
        return this;
    }

    public ServicioTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public ServicioTestDataBuilder conFechaProgramada(LocalDateTime fechaProgramada) {
        this.fechaProgramada = fechaProgramada;
        return this;
    }


    public ServicioTestDataBuilder conTipoUsuario(Long tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
        return this;
    }

    public ServicioTestDataBuilder conTipoServicio(Long tipoServicio) {
        this.tipoServicio = tipoServicio;
        return this;
    }

    public ServicioTestDataBuilder conIdMascota(Long idMascota) {
        this.idMascota = idMascota;
        return this;
    }

    public Servicio build() {
        return new Servicio(id,idUsuario,tipoUsuario,tipoServicio, idMascota, fechaProgramada);
    }
}
