package com.ceiba.servicio.servicio.testdatabuilder;

import com.ceiba.servicio.modelo.entidad.Servicio;


import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

public class ServicioTestDataBuilder {

    private Long id;
    private Long idUsuario;
    private Long tipoUsuario;
    private Long tipoServicio;
    private Long idMascota;

    private LocalDateTime fechaProgramada;



    public ServicioTestDataBuilder() {
        LocalDateTime dateTime = LocalDate.now().atTime(10, 0);
        LocalDateTime fechaServicio = dateTime.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        idUsuario = 36l;
        tipoUsuario = 1l;
        tipoServicio = 1l;
        idMascota = 1l;
        fechaProgramada = fechaServicio;;
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
