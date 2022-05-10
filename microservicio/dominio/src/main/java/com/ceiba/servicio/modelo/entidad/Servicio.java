package com.ceiba.servicio.modelo.entidad;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.*;

@Getter
@Setter
public class Servicio {

    private static final String SE_DEBE_INGRESAR_ID_DEL_CLIENTE = "Se debe ingresar id usuario";
    private static final String SE_DEBE_INGRESAR_TIPO_USUARIO = "Se debe ingresar tipo usuario";
    private static final String SE_DEBE_INGRESAR_TIPO_SERVICIO = "Se debe ingresar el tipo servicio";
    private static final String SE_DEBE_ID_MASCOTA = "Se debe id de la mascota";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_PROGRAMADA = "Se debe ingresar la fecha Programada";
    private static final String LA_FECHA_NO_PUEDE_SER_UN_DOMINGO = "Se debe programar la cita en un dia habil L-V";
    private static final String LA_FECHA_NO_PUEDE_SER_ANTES = "Fecha no valida";
    private static final String LA_HORA_NO_PUEDE_SER_MAYOR_A_LAS_4PM = "Hora no valida";

    private static final String SE_DEBE_INGRESAR_TIPO_USUARIO_CORRECTO = "Se debe ingresar tipo usuario correcto";
    private static final String SE_DEBE_INGRESAR_TIPO_SERVICIO_CORRECTO = "Se debe ingresar el tipo servicio correcto";

    private Long id;
    private Long idUsuario;
    private Long tipoUsuario;
    private Long tipoServicio;
    private Long idMascota;

    private LocalDateTime fechaProgramada;
    private LocalDateTime fechaEntrega;
    private LocalDateTime fechaContable;
    private Double total;



    public Servicio(Long id, Long idUsuario, Long tipoUsuario, Long tipoServicio, Long idMascota, LocalDateTime fechaProgramada) {

        validarObligatorio(idUsuario, SE_DEBE_INGRESAR_ID_DEL_CLIENTE);
        validarObligatorio(tipoUsuario, SE_DEBE_INGRESAR_TIPO_USUARIO);
        validarObligatorio(tipoServicio, SE_DEBE_INGRESAR_TIPO_SERVICIO);
        validarObligatorio(idMascota, SE_DEBE_ID_MASCOTA);
        validarObligatorio(fechaProgramada, SE_DEBE_INGRESAR_LA_FECHA_PROGRAMADA);
        validarFechaNoDomingos(fechaProgramada, LA_FECHA_NO_PUEDE_SER_UN_DOMINGO);
        validarHoraNoMayor(fechaProgramada, LA_HORA_NO_PUEDE_SER_MAYOR_A_LAS_4PM);
        validarFechaNoMenorHoy(fechaProgramada, LA_FECHA_NO_PUEDE_SER_ANTES);
        validarTipoServicio(tipoServicio, SE_DEBE_INGRESAR_TIPO_SERVICIO_CORRECTO);
        validarTipoCliente(tipoUsuario, SE_DEBE_INGRESAR_TIPO_USUARIO_CORRECTO);
        this.id = id;
        this.idUsuario = idUsuario;
        this.tipoUsuario = tipoUsuario;
        this.tipoServicio = tipoServicio;
        this.idMascota = idMascota;
        this.fechaProgramada = fechaProgramada;

    }
}
