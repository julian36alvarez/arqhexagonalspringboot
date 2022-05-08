package com.ceiba.servicio.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoServicio {
    private Long id;
    private Long idUsuario;
    private Long tipoUsuario;
    private Long tipoServicio;
    private Long idMascota;
    private Double total;
    private LocalDateTime fechaProgramada;
    private LocalDateTime fechaEntrega;
    private LocalDateTime fechaContable;
}
