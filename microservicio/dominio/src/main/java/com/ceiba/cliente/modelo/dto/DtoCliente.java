package com.ceiba.cliente.modelo.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class DtoCliente {
    private Long id;
    private Long identificacion;
    private String nombre;
    private String direccion;
    private Long telefono;

}
