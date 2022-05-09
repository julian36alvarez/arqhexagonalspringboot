package com.ceiba.mascota.modelo.entidad;

import lombok.Getter;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;
import static com.ceiba.dominio.ValidadorArgumento.validarValido;

@Getter
public class Mascota {

    private Long id;
    private String  nombre;
    private String especie;
    private String raza;

    private Long idCliente;


    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DE_LA_MASCOTA = "Se debe ingresar el nombre de la mascota";
    private static final String SE_DEBE_INGRESAR_LA_ESPECIE = "Se debe ingresar la especie de la mascota";
    private static final String SE_DEBE_INGRESAR_LA_RAZA = "Se debe ingresar la raza";
    private static final String ESPECIE_NO_VALIDA = "Especie no valida";

    private static final String SE_DEBE_INGRESAR_CLIENTE = "Se debe ingresar cliente";
    private enum ESPECIES {
        GATO,
        PERRO
    }

    public Mascota(Long id, String nombre, String especie, String raza, Long idCliente) {

        validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE_DE_LA_MASCOTA);
        validarObligatorio(especie, SE_DEBE_INGRESAR_LA_ESPECIE);
        validarObligatorio(raza, SE_DEBE_INGRESAR_LA_RAZA);
        validarObligatorio(idCliente, SE_DEBE_INGRESAR_CLIENTE);
        validarValido(especie,ESPECIES.class, ESPECIE_NO_VALIDA);
        this.id = id;
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.idCliente = idCliente;
    }
}
