package com.ceiba.servicio.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.servicio.modelo.entidad.Servicio;
import com.ceiba.servicio.puerto.repositorio.RepositorioServicio;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;


public class ServicioCrearServicio {

    private static final String EL_CLIENTE_NO_EXISTE_EN_EL_SISTEMA = "El cliente no existe, ingresar como cliente generico id = 2";

    private static final String LA_MASCOTA_NO_ESTA_CREADA = "La mascota no esta registrada en el sistema";

    private static final Double PRECIO_1 = 50000d;
    private static final Double PRECIO_2 = 45000d;
    private static final Double PRECIO_3 = 40000d;
    private static final double DESCUENTO_CLIENTE = 0.09;
    private static final double DESCUENTO_INVITADO = 0;


    private RepositorioServicio repositorioServicio;


    public ServicioCrearServicio(RepositorioServicio repositorioServicio) {
        this.repositorioServicio = repositorioServicio;
    }


    public Long ejecutar(Servicio servicio) {

        if(servicio.getTipoUsuario() == 1l){
            validarExistenciaCliente(servicio);
            validarExistenciaMascota(servicio);
        }
        Double total = calcularTotalAPagar(servicio.getTipoUsuario(), servicio.getTipoServicio(), servicio.getFechaProgramada());
        LocalDateTime fechaEntrega = calcularFechaEntrega(servicio.getFechaProgramada());
        LocalDateTime fechaContable = calcularFechaContable(servicio.getFechaProgramada());
        servicio.setTotal(total);
        servicio.setFechaEntrega(fechaEntrega);
        servicio.setFechaContable(fechaContable);
        return this.repositorioServicio.crear(servicio);
    }

    private LocalDateTime calcularFechaContable(LocalDateTime fechaProgramada) {
        int hora = fechaProgramada.getHour();
        if(hora >= 15){
            fechaProgramada = fechaProgramada.truncatedTo(ChronoUnit.DAYS);

            fechaProgramada = fechaProgramada.plusDays(1);
            if(fechaProgramada.getDayOfWeek() == DayOfWeek.SUNDAY){
                fechaProgramada = fechaProgramada.plusDays(1);
            }
        }
        return fechaProgramada;
    }

    private LocalDateTime calcularFechaEntrega(LocalDateTime fechaProgramada) {
        return fechaProgramada.plusHours(2);
    }

    private Double calcularTotalAPagar(Long tipoUsuario, Long tipoServicio, LocalDateTime fechaProgramada) {
        double descuento;
        double total = 0d;
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

    private void validarExistenciaCliente(Servicio servicio) {
        boolean existe = this.repositorioServicio.existePorIdCliente(servicio.getIdUsuario());
        if(!existe) {
            throw new ExcepcionDuplicidad(EL_CLIENTE_NO_EXISTE_EN_EL_SISTEMA);
        }
    }

    private void validarExistenciaMascota(Servicio servicio) {
        boolean existe = this.repositorioServicio.existePorIdMascota(servicio.getIdMascota());
        if(!existe) {
            throw new ExcepcionDuplicidad(LA_MASCOTA_NO_ESTA_CREADA);
        }
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
            esFestivo  =0.09;
        }
        return esFestivo;
    }

}
