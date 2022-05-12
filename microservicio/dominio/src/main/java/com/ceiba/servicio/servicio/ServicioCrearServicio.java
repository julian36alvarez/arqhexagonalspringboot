package com.ceiba.servicio.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
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


    private RepositorioServicio repositorioServicio;


    public ServicioCrearServicio(RepositorioServicio repositorioServicio) {
        this.repositorioServicio = repositorioServicio;
    }


    public Long ejecutar(Servicio servicio) {

        if(servicio.getTipoUsuario() == 1l){
            validarExistenciaCliente(servicio);
            validarExistenciaMascota(servicio);
        }
        return this.repositorioServicio.crear(servicio);
    }


    private void validarExistenciaCliente(Servicio servicio) {
        boolean existe = this.repositorioServicio.existePorIdCliente(servicio.getIdUsuario());
        if(!existe) {
            throw new ExcepcionValorInvalido(EL_CLIENTE_NO_EXISTE_EN_EL_SISTEMA);
        }
    }

    private void validarExistenciaMascota(Servicio servicio) {
        boolean existe = this.repositorioServicio.existePorIdMascota(servicio.getIdMascota());
        if(!existe) {
            throw new ExcepcionDuplicidad(LA_MASCOTA_NO_ESTA_CREADA);
        }
    }


}
