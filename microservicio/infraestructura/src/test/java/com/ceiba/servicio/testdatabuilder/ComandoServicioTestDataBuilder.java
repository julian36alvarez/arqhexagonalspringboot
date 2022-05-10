package com.ceiba.servicio.testdatabuilder;

import com.ceiba.mascota.testdatabuilder.ComandoMascotaTestDataBuilder;
import com.ceiba.servicio.comando.ComandoServicio;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

public class ComandoServicioTestDataBuilder {

    private Long id;
    private Long idUsuario;
    private Long tipoUsuario;
    private Long tipoServicio;
    private Long idMascota;

    private LocalDateTime fechaProgramada;

    private LocalDateTime fechaEntrega;
    private LocalDateTime fechaContable;
    private Double total;
    public ComandoServicioTestDataBuilder() {
        LocalDateTime dateTime = LocalDate.now().atTime(10, 0);
        LocalDateTime fechaServicio = dateTime.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        idUsuario = 1l;
        tipoUsuario = 1l;
        tipoServicio = 1l;
        idMascota = 1l;
        fechaProgramada = fechaServicio;;
    }

    public ComandoServicioTestDataBuilder conFechaProgramada(LocalDateTime fechaProgramada) {
        this.fechaProgramada = fechaProgramada;
        return this;
    }


    public ComandoServicio build() {
        return new ComandoServicio(id,idUsuario,tipoUsuario,tipoServicio, idMascota, fechaProgramada);
    }
}
