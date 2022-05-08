package com.ceiba.cliente.modelo.entidad;



import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;

import java.util.List;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Cliente {

    private static final String SE_DEBE_INGRESAR_LA_IDENTIFICACION_DEL_CLIENTE = "Se debe ingresar la identificacion";
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DE_CLIENTE = "Se debe ingresar el nombre";
    private static final String SE_DEBE_INGRESAR_LA_DIRECCION = "Se debe ingresar la direccion";
    private static final String SE_DEBE_INGRESAR_EL_TELEFONO = "Se debe ingresar el telefono";

    private Long id;
    private Long identificacion;
    private String nombre;
    private String direccion;
    private Long telefono;


    public Cliente(Long id, Long identificacion, String nombre, String direccion, Long telefono) {

        validarObligatorio(identificacion, SE_DEBE_INGRESAR_LA_IDENTIFICACION_DEL_CLIENTE);
        validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE_DE_CLIENTE);
        validarObligatorio(direccion, SE_DEBE_INGRESAR_LA_DIRECCION);
        validarObligatorio(telefono, SE_DEBE_INGRESAR_EL_TELEFONO);
        this.id = id;
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }


}
