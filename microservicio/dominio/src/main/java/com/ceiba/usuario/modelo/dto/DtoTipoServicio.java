package com.ceiba.usuario.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoTipoServicio {

    private Long id;
    private String descripcion;
    private Double costo;
}
