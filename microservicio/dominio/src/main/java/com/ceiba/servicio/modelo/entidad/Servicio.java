package com.ceiba.servicio.modelo.entidad;

import lombok.Getter;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import static com.ceiba.dominio.ValidadorArgumento.*;

@Getter
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
    private static final Double PRECIO_1 = 50000d;
    private static final Double PRECIO_2 = 45000d;
    private static final Double PRECIO_3 = 40000d;
    private static final double DESCUENTO_CLIENTE = 0.09;
    private static final double DESCUENTO_INVITADO = 0;

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
        this.total = calcularTotalAPagar(tipoUsuario, tipoServicio, fechaProgramada);
        this.fechaEntrega = calcularFechaEntrega(fechaProgramada);
        this.fechaContable = calcularFechaContable(fechaProgramada);

    }

    private Double calcularTotalAPagar(Long tipoUsuario, Long tipoServicio, LocalDateTime fechaProgramada) {
        double descuento;
        total = 0d;
        double esFestivo =  validarSiEsFestivos(fechaProgramada);
        if(tipoUsuario== 1l){
            descuento = DESCUENTO_CLIENTE;
        }else {
            descuento = DESCUENTO_INVITADO;
        }
        if(tipoServicio == 1l){
            total =  PRECIO_1 - (PRECIO_1*descuento) + (PRECIO_1*esFestivo);
        } else if (tipoServicio == 2l) {
            total =  PRECIO_2 - (PRECIO_2*descuento) + (PRECIO_2*esFestivo);
        }else if (tipoServicio == 3l) {
            total =  PRECIO_3 - (PRECIO_3*descuento) + (PRECIO_3*esFestivo);
        }
        return total;
    }

    public double validarSiEsFestivos(LocalDateTime fechaProgramada){

        double esFestivo = 0;
        ArrayList<LocalDate> festivosColombia = new ArrayList<>();
        LocalDate diaProgramado = LocalDate.from(fechaProgramada);
        festivosColombia.add((LocalDate.of(2022,1,1)));
        festivosColombia.add((LocalDate.of(2022,1,10)));
        festivosColombia.add((LocalDate.of(2022,3,21)));
        festivosColombia.add((LocalDate.of(2022,4,14)));
        festivosColombia.add((LocalDate.of(2022,4,15)));
        festivosColombia.add((LocalDate.of(2022,5,1)));
        festivosColombia.add((LocalDate.of(2022,5,30)));
        festivosColombia.add((LocalDate.of(2022,1,20)));
        festivosColombia.add((LocalDate.of(2022,6,27)));
        festivosColombia.add((LocalDate.of(2022,6,4)));
        festivosColombia.add((LocalDate.of(2022,7,20)));
        festivosColombia.add((LocalDate.of(2022,8,7)));
        festivosColombia.add((LocalDate.of(2022,8,15)));
        festivosColombia.add((LocalDate.of(2022,10,17)));
        festivosColombia.add((LocalDate.of(2022,11,7)));
        festivosColombia.add((LocalDate.of(2022,11,14)));
        festivosColombia.add((LocalDate.of(2022,12,8)));
        festivosColombia.add((LocalDate.of(2022,12,25)));

        if ( festivosColombia.contains(diaProgramado)) {
            esFestivo  =1;
        }
        return esFestivo;
    }

    private LocalDateTime calcularFechaContable(LocalDateTime fechaProgramada) {
        int hora = fechaProgramada.getHour();
        if(hora >= 15){
            fechaProgramada = fechaProgramada.truncatedTo(ChronoUnit.DAYS);
            fechaProgramada = fechaProgramada.plusDays(1);
            if(fechaProgramada.getDayOfWeek() == DayOfWeek.SATURDAY ){
                fechaProgramada = fechaProgramada.plusDays(1);
            }
        }
        return fechaProgramada;
    }

    private LocalDateTime calcularFechaEntrega(LocalDateTime fechaProgramada) {
        return fechaProgramada.plusHours(2);
    }

}
